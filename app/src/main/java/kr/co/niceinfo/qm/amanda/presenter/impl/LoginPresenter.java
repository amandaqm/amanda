package kr.co.niceinfo.qm.amanda.presenter.impl;

import android.content.Context;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.messaging.FirebaseMessaging;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.presenter.LoginMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.ui.activity.MainActivity;
import kr.co.niceinfo.qm.amanda.utils.CommonUtils;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public final class LoginPresenter extends BasePresenter<LoginMVP.View> implements LoginMVP.Presenter {

    private static final String TAG = "LoginPresenter";



    @Inject
    public LoginPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }




    @Override
    public void login(User user) {
        String email = user.getInteralMail();
        String password = user.getUserPw();

        //validate email and password
        if (email == null || email.isEmpty()) {
            //getAmandaView().onError(R.string.empty_email);
            getAmandaView().onError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            //getAmandaView().onError(R.string.invalid_email);
            getAmandaView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            //getAmandaView().onError(R.string.empty_password);
            getAmandaView().onError(R.string.empty_password);
            return;
        }

        //로딩화면 show
        getAmandaView().showLoading();

        final Observable<AuthResult> observable = getDataManager().login(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Disposable d = observable.subscribe(auth-> {
            getDataManager().setCurrentUserEmail(auth.getUser().getEmail());

            if(auth.getUser().isEmailVerified()){
                getAmandaView().loginSuccess();
                FirebaseMessaging.getInstance().subscribeToTopic("notice");

                //로그아웃 시 unsubscribe 해야함
                //FirebaseMessaging.getInstance().subscribeToTopic("notice");
            }
            else {
                getDataManager().sendEmailVerification();
                getAmandaView().showMessage(R.string.email_verification);
            }
            getAmandaView().hideLoading();
        }, error-> {
            getAmandaView().loginFailed();
            getAmandaView().onError(error.getLocalizedMessage());
            getAmandaView().hideLoading();
        });
        getCompositeDisposable().add(d);
    }




    @Override
    public void goToMain(Context context) {
        MainActivity.startMe(context);
    }

}
