
package kr.co.niceinfo.qm.amanda.presenter.notice;


import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.notice.reg.NoticeRegMvpView;
import kr.co.niceinfo.qm.amanda.presenter.base.AmandaPresenter;


@PerActivity
public interface NoticeRegMvpPresenter<V extends NoticeRegMvpView> extends AmandaPresenter<V> {
    Board regNotice(Board notice);
    String getInteralMail();
    void getNoticeInfo(String noticeKey);
}
