package kr.co.niceinfo.qm.amanda.presenter;

import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

/**
 * Created by fruitbites on 2017-10-05.
 */

public interface NoticeViewMVP {
    interface View extends AmandaView {
        void onDeleteSuccess();
    }
    interface Presenter  {
        void delete(Board board);

    }
}
