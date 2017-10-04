package kr.co.niceinfo.qm.amanda.ui.notice.reg;

import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

public interface NoticeRegMvpView extends AmandaView {

    void openNoticeListActivity();

    void settingNoticeInfo(Board notice);
}
