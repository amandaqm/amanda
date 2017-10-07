package kr.co.niceinfo.qm.amanda.data.firebase;

import com.google.firebase.auth.AuthResult;

import java.util.List;

import io.reactivex.Observable;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.data.db.model.Crisis;
import kr.co.niceinfo.qm.amanda.data.db.model.Level;
import kr.co.niceinfo.qm.amanda.data.db.model.Member;
import kr.co.niceinfo.qm.amanda.data.db.model.User;

/**
 * Created by Woo-Young on 2017-09-02.
 */

public interface FirebaseHelper {

    Observable<AuthResult> register(final User user);
    public Observable<Member> updateUserInDatabase(Member member);
    Observable<Member> getMember(String uid);

    Observable<AuthResult> login(final User user);

    Observable<Void> logout() ;

    Observable<Void> sendEmailVerification();

    Observable<List<Board>> getBoards();

    Observable<Object> insertBoard(Board board);
    Observable<Object> updateBoard(Board board);
    Observable<Object> deleteBoard(Board board);

    Observable<Board> getBoard(String noticeKey);

    Observable<List<Level>> getCrisisLevels(String name);
    Observable<List<Crisis>> getCrisis(String name);
}
