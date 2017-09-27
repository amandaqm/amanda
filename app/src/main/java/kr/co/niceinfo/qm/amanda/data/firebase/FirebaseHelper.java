package kr.co.niceinfo.qm.amanda.data.firebase;

import com.google.firebase.auth.AuthResult;

import java.util.List;

import io.reactivex.Observable;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.data.db.model.User;

/**
 * Created by Woo-Young on 2017-09-02.
 */

public interface FirebaseHelper {

    Observable<AuthResult> registerUser(final User user);

    Observable<AuthResult> login(final User user);

    Observable<Void> sendEmailVerification();

    Observable<List<Board>> getBoards();

    Observable<Object> insertBoard(Board board);


}
