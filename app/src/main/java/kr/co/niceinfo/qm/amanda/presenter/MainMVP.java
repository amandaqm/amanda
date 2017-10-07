package kr.co.niceinfo.qm.amanda.presenter;

import android.content.Context;

import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

/**
 * Created by fruitbites on 2017-10-05.
 */

public interface MainMVP {
    interface View extends AmandaView {

    }
    interface Presenter  {
        public void onMenuItemSettingsClick(Context context);
        public void onMenuItemNoticeListClick(Context context);
    }
}
