
package kr.co.niceinfo.qm.amanda.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.di.ActivityContext;
import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.ui.login.LoginMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.login.LoginMvpView;
import kr.co.niceinfo.qm.amanda.ui.login.LoginPresenter;
import kr.co.niceinfo.qm.amanda.ui.main.MainMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.main.MainMvpView;
import kr.co.niceinfo.qm.amanda.ui.main.MainPresenter;
import kr.co.niceinfo.qm.amanda.ui.main.btnmenu.MainMenuMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.main.btnmenu.MainMenuMvpView;
import kr.co.niceinfo.qm.amanda.ui.main.btnmenu.MainMenuPresenter;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListMvpView;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListPresenter;
import kr.co.niceinfo.qm.amanda.ui.splash.SplashMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.splash.SplashMvpView;
import kr.co.niceinfo.qm.amanda.ui.splash.SplashPresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.AppSchedulerProvider;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMenuMvpPresenter<MainMenuMvpView> provideMainMenuPresenter(
            MainMenuPresenter<MainMenuMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    NoticeListMvpPresenter<NoticeListMvpView> provideNoticeListPresenter(
            NoticeListPresenter<NoticeListMvpView> presenter) {
        return presenter;
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }



}
