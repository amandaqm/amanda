
package kr.co.niceinfo.qm.amanda.ui.main.btnmenu;


import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaPresenter;


@PerActivity
public interface MainMenuMvpPresenter<V extends MainMenuMvpView> extends AmandaPresenter<V> {

    void onRuleBtnClick();

    void onChatBtnClick();

    void onContactBtnClick();


}
