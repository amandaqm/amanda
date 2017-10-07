package kr.co.niceinfo.qm.amanda.presenter.impl;

import android.content.Context;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.presenter.OnBoardingMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.ui.activity.RegisterActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.LoginActivity;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public final class OnBoardingPresenter extends BasePresenter<OnBoardingMVP.View> implements OnBoardingMVP.Presenter {

    @Inject
    public OnBoardingPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }


    @Override
    public void goToLogin(Context context) {

        LoginActivity.startMe(context);
    }

    @Override
    public void goToRegister(Context context) {
        RegisterActivity.startMe(context);
    }

}
