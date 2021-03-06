package kr.co.niceinfo.qm.amanda.data.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

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
    public Observable<Object> insertBoard(Board board) {
        Log.i(TAG, "AppFirebaseHelper : " + "insertBoard");

        String key = getChildReference().push().getKey();
        board.setKey(key);
        return RxFirebase.getObservable(getChildReference().child(key).setValue(board), board);
    }

    @Override
    public Observable<List<Board>> getBoards() {
        Log.i(TAG, "AppFirebaseHelper : " + "getBoards");
        return RxFirebase.getObservableForSingleEventList(this.firebaseDatabase.getReference().child("amanda").child("boards").child("notice"), Board.class);
    }

    @Override
    public Observable<Board> getBoard(String noticeKey) {
        Log.i(TAG, "AppFirebaseHelper getBoard - noticeKey: " + noticeKey);
        return RxFirebase.getObservableForSingleEvent(getChildReference().child(noticeKey), Board.class);
    }

    public DatabaseReference getChildReference() {
        this.childReference = this.firebaseDatabase.
                getReference("amanda/boards/notice");
        return childReference;
    }


}
