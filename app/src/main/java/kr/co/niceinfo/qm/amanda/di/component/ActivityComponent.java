package kr.co.niceinfo.qm.amanda.di.component;

import dagger.Component;
import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.di.module.ActivityModule;
import kr.co.niceinfo.qm.amanda.ui.login.LoginActivity;
import kr.co.niceinfo.qm.amanda.ui.main.MainActivity;
import kr.co.niceinfo.qm.amanda.ui.main.btnmenu.MainMenuFragment;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListActivityFragment;
import kr.co.niceinfo.qm.amanda.ui.notice.reg.NoticeRegActivityFragment;
import kr.co.niceinfo.qm.amanda.ui.splash.SplashActivity;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(MainMenuFragment fragment);

    void inject(NoticeListActivityFragment fragment);

    void inject(NoticeRegActivityFragment fragment);

}
