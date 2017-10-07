package kr.co.niceinfo.qm.amanda.di.component;

import dagger.Component;
import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.di.module.ActivityModule;
import kr.co.niceinfo.qm.amanda.ui.activity.LoginActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.MainActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.NoticeActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.OnBoardingActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.RegisterActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.SettingActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.SplashActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.feed.FeedActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.notice.list.NoticeListActivityFragment;
import kr.co.niceinfo.qm.amanda.ui.activity.notice.reg.NoticeRegActivityFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.CrisisStageFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.NoticeEditFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.NoticeListFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.NoticeViewFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.blog.BlogFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.btnmenu.MainMenuFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.opensource.OpenSourceFragment;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(OnBoardingActivity activity);
    void inject(RegisterActivity activity);
    void inject(MainActivity activity);
    void inject(SettingActivity activity);

    void inject(NoticeActivity activity);
    void inject(NoticeListFragment fragment);
    void inject(NoticeViewFragment fragment);
    void inject(NoticeEditFragment fragment);

    void inject(CrisisStageFragment fragment);



    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(MainMenuFragment fragment);

    //void inject(NoticeListActivity activity);

    void inject(NoticeListActivityFragment fragment);

    void inject(NoticeRegActivityFragment fragment);




    void inject(FeedActivity activity);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);




}
