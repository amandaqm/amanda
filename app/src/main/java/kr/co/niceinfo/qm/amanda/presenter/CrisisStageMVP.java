package kr.co.niceinfo.qm.amanda.presenter;

import java.util.Date;

import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;

/**
 * Created by fruitbites on 2017-10-05.
 */

public interface CrisisStageMVP {
    interface View extends AmandaView {
        void service(String level,Date date,String desc);
        void security(String level, Date date,String desc);
    }
    interface Presenter  {
        void show();
    }
}
