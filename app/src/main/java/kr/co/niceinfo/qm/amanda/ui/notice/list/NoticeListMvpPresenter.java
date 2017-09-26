
package kr.co.niceinfo.qm.amanda.ui.notice.list;


import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaPresenter;


@PerActivity
public interface NoticeListMvpPresenter<V extends NoticeListMvpView> extends AmandaPresenter<V> {

    //공지등록 버튼 클릭 시
    void onNoticeRegBtnClick();

    void getBoards();

}
