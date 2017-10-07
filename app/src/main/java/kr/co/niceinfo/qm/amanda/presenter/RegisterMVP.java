package kr.co.niceinfo.qm.amanda.presenter;

import android.content.Context;

import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

/**
 * Created by fruitbites on 2017-10-05.
 */

public interface RegisterMVP {
    interface View extends AmandaView {
        void registerSuccess();
        void registerFailed();
    }

    interface Presenter {
        void register(User user);
        void goToLogin(Context context);
    }
}
