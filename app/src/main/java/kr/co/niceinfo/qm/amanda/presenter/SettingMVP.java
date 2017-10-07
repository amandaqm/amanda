package kr.co.niceinfo.qm.amanda.presenter;

import kr.co.niceinfo.qm.amanda.data.db.model.Member;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

/**
 * Created by fruitbites on 2017-10-05.
 */

public interface SettingMVP {
    interface View extends AmandaView {
        void updateSuccess();
        void updateFailed();
        void loadSuccess(Member member);
        void loadFailed();
    }

    interface Presenter {
        void update(Member member);
        void loadMember(String uid);
    }
}
