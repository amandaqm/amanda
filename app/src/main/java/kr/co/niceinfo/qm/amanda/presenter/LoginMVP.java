package kr.co.niceinfo.qm.amanda.presenter;

import android.content.Context;

import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

/**
 * Created by fruitbites on 2017-10-05.
 */

public interface LoginMVP {
    interface View extends AmandaView {
        void loginSuccess();
        void loginFailed();
    }

    interface Presenter {
        void login(User user);
        void goToMain(Context context);
    }
}
