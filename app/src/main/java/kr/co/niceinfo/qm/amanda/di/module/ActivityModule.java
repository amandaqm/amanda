
package kr.co.niceinfo.qm.amanda.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.data.network.model.BlogResponse;
import kr.co.niceinfo.qm.amanda.data.network.model.OpenSourceResponse;
import kr.co.niceinfo.qm.amanda.di.ActivityContext;
import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.ui.feed.FeedMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.feed.FeedMvpView;
import kr.co.niceinfo.qm.amanda.ui.feed.FeedPagerAdapter;
import kr.co.niceinfo.qm.amanda.ui.feed.FeedPresenter;
import kr.co.niceinfo.qm.amanda.ui.feed.blog.BlogAdapter;
import kr.co.niceinfo.qm.amanda.ui.feed.blog.BlogMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.feed.blog.BlogMvpView;
import kr.co.niceinfo.qm.amanda.ui.feed.blog.BlogPresenter;
import kr.co.niceinfo.qm.amanda.ui.feed.opensource.OpenSourceAdapter;
import kr.co.niceinfo.qm.amanda.ui.feed.opensource.OpenSourceMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.feed.opensource.OpenSourceMvpView;
import kr.co.niceinfo.qm.amanda.ui.feed.opensource.OpenSourcePresenter;
import kr.co.niceinfo.qm.amanda.ui.login.LoginMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.login.LoginMvpView;
import kr.co.niceinfo.qm.amanda.ui.login.LoginPresenter;
import kr.co.niceinfo.qm.amanda.ui.main.MainMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.main.MainMvpView;
import kr.co.niceinfo.qm.amanda.ui.main.MainPresenter;
import kr.co.niceinfo.qm.amanda.ui.main.btnmenu.MainMenuMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.main.btnmenu.MainMenuMvpView;
import kr.co.niceinfo.qm.amanda.ui.main.btnmenu.MainMenuPresenter;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeAdapter;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListMvpView;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListPresenter;
import kr.co.niceinfo.qm.amanda.ui.notice.reg.NoticeRegMvpPresenter;
import kr.co.niceinfo.qm.amanda.ui.notice.reg.NoticeRegMvpView;
import kr.co.niceinfo.qm.amanda.ui.notice.reg.NoticeRegPresenter;
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
    @PerActivity
    NoticeRegMvpPresenter<NoticeRegMvpView> provideNoticeRegPresenter(
            NoticeRegPresenter<NoticeRegMvpView> presenter) {
        return presenter;
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }



    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {

        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    NoticeAdapter provideNoticeAdapter() {
        return new NoticeAdapter(new ArrayList<Board>());
    }

}
