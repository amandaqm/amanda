
package kr.co.niceinfo.qm.amanda.ui.fragment.btnmenu;


import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.presenter.base.AmandaPresenter;


@PerActivity
public interface MainMenuMvpPresenter<V extends MainMenuMvpView> extends AmandaPresenter<V> {

    //로그인 사용자 이메일주소 반환
    String getInteralMail();

    void onRuleBtnClick();

    void onChatBtnClick();

    void onContactBtnClick();

    void onNoticeBtnClick();

}
