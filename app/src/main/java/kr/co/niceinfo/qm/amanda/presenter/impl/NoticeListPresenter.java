package kr.co.niceinfo.qm.amanda.presenter.impl;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.presenter.NoticeListMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public final class NoticeListPresenter extends BasePresenter<NoticeListMVP.View> implements NoticeListMVP.Presenter {

    private static final String TAG = "NoticeListPresenter";



    @Inject
    public NoticeListPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }


}
