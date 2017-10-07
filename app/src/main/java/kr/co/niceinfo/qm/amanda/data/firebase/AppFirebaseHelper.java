package kr.co.niceinfo.qm.amanda.data.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.data.db.model.Crisis;
import kr.co.niceinfo.qm.amanda.data.db.model.Level;
import kr.co.niceinfo.qm.amanda.data.db.model.Member;
import kr.co.niceinfo.qm.amanda.data.db.model.User;

/**
 * Created by Woo-Young on 2017-09-02.
 */
@Singleton
public class AppFirebaseHelper implements FirebaseHelper {

    private static final String TAG = "AppFirebaseHelper";

    private DatabaseReference noticeReference = null;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;


    @Inject
    public AppFirebaseHelper(FirebaseAuth firebaseAuth, FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        this.firebaseAuth = firebaseAuth;
    }


    //회원가입
    public Observable<AuthResult> register(final User user) {
        Log.i(TAG, "" + user.toString());
        return RxFirebase.getObservable(firebaseAuth.createUserWithEmailAndPassword(user.getInteralMail(),
                user.getUserPw()));
    }


    /**
     * 로그인
     *
     * @param user
     * @return
     */
    public Observable<AuthResult> login(User user) {
        Log.i(TAG, "AppFirebaseHelper : " + user.toString());
        return RxFirebase.getObservable(firebaseAuth.signInWithEmailAndPassword(user.getInteralMail(),
                user.getUserPw()));
    }

    /**
     * 로그아웃
     *
     * @return
     */
    public Observable<Void> logout() {
        return Observable.defer(new Callable<ObservableSource<? extends Void>>() {
            @Override
            public ObservableSource<? extends Void> call() throws Exception {
                firebaseAuth.signOut();
                return Observable.just(null);
            }
        });
    }



    /**
     * 사용자 기록
     */
    public Observable<Member> updateUserInDatabase(Member member) {

        {
            Query queryRef = getDepartmentsReference();
            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    DatabaseReference ref = dataSnapshot.getRef().child("members").child(member.getUid());
                    ref.removeValue();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }


        {
            DatabaseReference ref = getMembersReference().child(member.getUid());

            Map m = new HashMap();
            m.put("name", member.getName());
            m.put("department", member.getDepartment());
            m.put("tel", member.getTel());
            m.put("etel", member.getEtel());
            ref.updateChildren(m);
        }
        {
            Query queryRef = getDepartmentsReference().orderByChild("name").equalTo(member.getDepartment());
            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    DatabaseReference ref = dataSnapshot.getRef();


                    Map m = new HashMap();
                    m.put(member.getUid(),new Boolean(true));
                    ref.child("members").updateChildren(m);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

        return Observable.just(member);
    }


    @Override
    public Observable<Member> getMember(String uid) {

        return RxFirebase.getObservableForSingleEvent(getMembersReference().child(uid), Member.class);
    }





    @Override
    @NonNull
    public Observable<Void> sendEmailVerification() {
        Log.i(TAG, "AppFirebaseHelper : " + "sendEmailVerification");
        return RxFirebase.getObservable(firebaseAuth.getCurrentUser().sendEmailVerification());
    }


    @Override
    public Observable<Object> insertBoard(Board board) {
        Log.i(TAG, "AppFirebaseHelper : " + "insertBoard");

        String key = getNoticeReference().push().getKey();
        board.setKey(key);

        return RxFirebase.getObservable(getNoticeReference().child(key).setValue(board), board);
    }

    @Override
    public Observable<Object> updateBoard(Board board) {
        String key = board.getKey();
        return RxFirebase.getObservable(getNoticeReference().child(key).setValue(board), board);
    }

    @Override
    public Observable<Object> deleteBoard(Board board) {
        String key = board.getKey();
        return RxFirebase.getObservable(getNoticeReference().child(key).setValue(null), board);
    }

    @Override
    public Observable<List<Board>> getBoards() {
        Log.i(TAG, "AppFirebaseHelper : " + "getBoards");
        return RxFirebase.getObservableForSingleEventList(this.firebaseDatabase.getReference().child("amanda").child("boards").child("notice"), Board.class);
    }

    @Override
    public Observable<Board> getBoard(String noticeKey) {
        Log.i(TAG, "AppFirebaseHelper getBoard - noticeKey: " + noticeKey);
        return RxFirebase.getObservableForSingleEvent(getNoticeReference().child(noticeKey), Board.class);
    }

    @Override
    public Observable<List<Level>> getCrisisLevels(String name) {
        return RxFirebase.getObservableForSingleEventList(this.firebaseDatabase.getReference().child("amanda").child("stage").child(name), Level.class);
    }

    @Override
    public Observable<List<Crisis>> getCrisis(String name) {
        return RxFirebase.getObservable(this.firebaseDatabase.getReference().child("amanda").child("crisis").child(name), Crisis.class);
    }


    public DatabaseReference getDepartmentsReference() {
        return this.firebaseDatabase.getReference("amanda/departments");
    }

    public DatabaseReference getMembersReference() {
        return this.firebaseDatabase.getReference("amanda/members");
    }


    public DatabaseReference getNoticeReference() {
        this.noticeReference = this.firebaseDatabase.
                getReference("amanda/boards/notice");
        return noticeReference;
    }


}
