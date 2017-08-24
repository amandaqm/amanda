package kr.co.niceinfo.qm.amanda.ui.login;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.ui.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.CommonUtils;


public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(
                          //DataManager dataManager,
                          //SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        //super(dataManager, schedulerProvider, compositeDisposable);
        super(compositeDisposable);
    }

    @Override
    public void onServerLoginClick(String email, String password) {

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

        //로딩화면 hide
        getAmandaView().hideLoading();

        //메인화면으로 이동
        getAmandaView().openMainActivity();

        //기존 로그인 체크 로직
        /*
        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        getDataManager().updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().openMainActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
           */
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
