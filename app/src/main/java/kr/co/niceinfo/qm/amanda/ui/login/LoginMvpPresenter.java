
package kr.co.niceinfo.qm.amanda.ui.login;


import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaPresenter;


@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends AmandaPresenter<V> {

    void onRegisterUser(User user);

    void onServerLoginClick(User user);

    void onGoogleLoginClick();

    void onFacebookLoginClick();

}
