package kr.co.niceinfo.qm.amanda.presenter.impl;

import android.content.Context;
import android.util.Log;

import com.google.firebase.auth.AuthResult;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.presenter.RegisterMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.ui.activity.LoginActivity;
import kr.co.niceinfo.qm.amanda.utils.CommonUtils;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public final class RegisterPresenter extends BasePresenter<RegisterMVP.View> implements RegisterMVP.Presenter {

    private static final String TAG = "RegisterPresenter";



    @Inject
    public RegisterPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    @Override
    public void register(User user) {
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

        final Observable<AuthResult> observable = getDataManager().register(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Disposable d = observable.subscribe(auth-> {
            getDataManager().setCurrentUserEmail(auth.getUser().getEmail());
            //메일 전송 성공하는 경우와 실패하는 경우 잡아서 적절한 toast띄우기
            getDataManager().sendEmailVerification();
            getAmandaView().registerSuccess();
            getAmandaView().showMessage(R.string.email_verification_send_to);
            //로딩화면 hide
            getAmandaView().hideLoading();
        }, error-> {
            getAmandaView().registerFailed();
            getAmandaView().onError(error.getLocalizedMessage());
            getAmandaView().hideLoading();
        });

        getCompositeDisposable().add(d);

    }






    @Override
    public void goToLogin(Context context) {
        LoginActivity.startMe(context);
    }

}
