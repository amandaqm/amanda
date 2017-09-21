package kr.co.niceinfo.qm.amanda.ui.login;

import android.util.Log;

import com.google.firebase.auth.AuthResult;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.ui.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.CommonUtils;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }


    @Override
    public void onRegisterUser(User user) {
        //회원가입
        Log.i(TAG, "onRegisterUser: " + user.toString());
        String email = user.getInteralMail();
        String password = user.getUserPw();

        //validate email and password
        if (email == null || email.isEmpty()) {
            getAmandaView().onError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getAmandaView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getAmandaView().onError(R.string.empty_password);
            return;
        }

        //로딩화면 show
        getAmandaView().showLoading();

        getCompositeDisposable().add(getDataManager().registerUser(user)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<AuthResult>() {
                               @Override
                               public void accept(@NonNull AuthResult authResult) throws Exception {
                                   Log.i(TAG, authResult.getUser().getEmail());
                                   getDataManager().setCurrentUserEmail(authResult.getUser().getEmail());
                                   //메일 전송 성공하는 경우와 실패하는 경우 잡아서 적절한 toast띄우기
                                   getDataManager().sendEmailVerification();

                                   getAmandaView().onError("Verification email sent to " + authResult.getUser().getEmail());

                                   //로딩화면 hide
                                   getAmandaView().hideLoading();

                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   //로딩화면 hide
                                   getAmandaView().hideLoading();
                                   //이미 가입이 되어있는 건지 flag찾아서 경우에 따른 멘트 분기 필요
                                   getAmandaView().onError("이미 가입이 되어 있습니다.");
                               }
                           }
                ));
    }


    @Override
    public void onServerLoginClick(User user) {
        //로그인
        Log.i(TAG, "onServerLoginClick: " + user.toString());
        String email = user.getInteralMail();
        String password = user.getUserPw();

        //validate email and password
        if (email == null || email.isEmpty()) {
            //getAmandaView().onError(R.string.empty_email);
            getAmandaView().onError("R.string.empty_email");
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            //getAmandaView().onError(R.string.invalid_email);
            getAmandaView().onError("R.string.invalid_email");
            return;
        }
        if (password == null || password.isEmpty()) {
            //getAmandaView().onError(R.string.empty_password);
            getAmandaView().onError("R.string.empty_password");
            return;
        }

        //로딩화면 show
        getAmandaView().showLoading();

        getCompositeDisposable().add(getDataManager().login(user)
                                           .subscribeOn(getSchedulerProvider().io())
                                           .observeOn(getSchedulerProvider().ui())
                                           .subscribe(new Consumer<AuthResult>() {
                                               @Override
                                               public void accept(@NonNull AuthResult authResult) throws Exception {
                                                   Log.i(TAG, authResult.getUser().getEmail());
                                                   getDataManager().setCurrentUserEmail(authResult.getUser().getEmail());

                                                   if(authResult.getUser().isEmailVerified()){
                                                       getAmandaView().openMainActivity();
                                                   }else{
                                                       //메일 전송 성공하는 경우와 실패하는 경우 잡아서 적절한 toast띄우기
                                                       getDataManager().sendEmailVerification();
                                                       getAmandaView().onError("이메일 재인증을 해주세요.");
                                                   }
                                   //로딩화면 hide
                                   getAmandaView().hideLoading();
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   //로딩화면 hide
                                   getAmandaView().onError("로그인을 다시 시도해주세요.");
                                   getAmandaView().hideLoading();
                               }
                           }
                ));
    }

    @Override
    public void onGoogleLoginClick() {
        // instruct LoginActivity to initiate google login
    }

    @Override
    public void onFacebookLoginClick() {
        // instruct LoginActivity to initiate facebook login
    }
}
