
package kr.co.niceinfo.qm.amanda.ui.login;


import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaPresenter;


@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends AmandaPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();

}
