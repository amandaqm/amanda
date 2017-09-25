package kr.co.niceinfo.qm.amanda.data.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.data.db.model.User;

/**
 * Created by Woo-Young on 2017-09-02.
 */
@Singleton
public class AppFirebaseHelper implements FirebaseHelper {

    private static final String TAG = "AppFirebaseHelper";

    private DatabaseReference childReference = null;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;




    @Inject
    public AppFirebaseHelper(FirebaseAuth firebaseAuth, FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        this.firebaseAuth = firebaseAuth;
    }


    //회원가입
    public Observable<AuthResult> registerUser(final User user) {

        Log.i(TAG, "" + user.toString());

        return RxFirebase.getObservable(firebaseAuth.createUserWithEmailAndPassword(user.getInteralMail(),
                user.getUserPw()));
    }


    //로그인
    @Override
    public Observable<AuthResult> login(User user) {
        Log.i(TAG, "AppFirebaseHelper : " + user.toString());


        return RxFirebase.getObservable(firebaseAuth.signInWithEmailAndPassword(user.getInteralMail(),
                user.getUserPw()));
    }


    @Override
    @NonNull
    public Observable<Void> sendEmailVerification() {
        Log.i(TAG, "AppFirebaseHelper : " + "sendEmailVerification");
       return RxFirebase.getObservable(firebaseAuth.getCurrentUser().sendEmailVerification());
    }


    @Override
    public Observable<Board> getBoards() {
        Log.i(TAG, "AppFirebaseHelper : " + "getBoards");




        getChildReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, dataSnapshot.toString());

                Map<String, Object> objectMap = (HashMap<String, Object>)dataSnapshot.getValue();
                List<Board>  boardList = new ArrayList<>();
                for (Object obj : objectMap.values()) {
                    Log.d(TAG, "obj: "+obj.getClass());

                    if (obj instanceof Map) {
                        Map<String, Object> mapObj = (Map<String, Object>) obj;

                    }
                }

                Board board = dataSnapshot.getValue(Board.class);
                Log.d(TAG, "board: "+board.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return RxFirebase.getObservableForSingleEventToMapList(getChildReference(), Board.class);
    }



    @Override
    public Observable<Object> insertBoard(Board board) {
        Log.i(TAG, "AppFirebaseHelper : " + "insertBoard");

        String key= getChildReference().push().getKey();
        board.setKey(key);
        return RxFirebase.getObservable(getChildReference().child(key).setValue(board),board);
    }


    public DatabaseReference getChildReference() {
        //if (this.childReference==null) {
            this.childReference = this.firebaseDatabase.
                    getReference("amanda/boards/notice");
                   // .child("amanda")
                   // .child("boards")
                   // .child("notice");
        //}

        return childReference;
    }



}
