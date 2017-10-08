package kr.co.niceinfo.qm.amanda.presenter;

import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

/**
 * Created by fruitbites on 2017-10-05.
 */

public interface NoticeEditMVP {
    interface View extends AmandaView {
        void onUpdateSuccess();
    }
    interface Presenter  {
        void update(Board board);
    }
}