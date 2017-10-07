package kr.co.niceinfo.qm.amanda.presenter.impl;

import android.content.Context;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.presenter.MainMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.ui.activity.NoticeActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.SettingActivity;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;

public final class MainPresenter extends BasePresenter<MainMVP.View> implements MainMVP.Presenter {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void setUserAsLoggedOut() {
        // 로그아웃 시 사용할 참고 정보
        // FirebaseAuth.getInstance().signOut();
    }

    @Override
    public void onAttach(MainMVP.View view) {

        super.onAttach(view);
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void handleApiError(ANError error) {

    }

    @Override
    public void onMenuItemSettingsClick(Context context) {
        SettingActivity.startMe(context);
    }

    @Override
    public void onMenuItemNoticeListClick(Context context) {
        NoticeActivity.startMe(context);
    }
}
