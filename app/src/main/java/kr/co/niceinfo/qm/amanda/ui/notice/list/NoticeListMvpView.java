package kr.co.niceinfo.qm.amanda.ui.notice.list;

import java.util.List;

import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

public interface NoticeListMvpView extends AmandaView {

    void openNoticeRegActivity();

    void updateNotice(List<Board> boardList);

    NoticeAdapter getmNoticeAdapter();
}
