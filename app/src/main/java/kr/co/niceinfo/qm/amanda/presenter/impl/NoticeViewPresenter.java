package kr.co.niceinfo.qm.amanda.presenter.impl;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.presenter.NoticeViewMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;
import timber.log.Timber;


public final class NoticeViewPresenter extends BasePresenter<NoticeViewMVP.View> implements NoticeViewMVP.Presenter {

    private static final String TAG = "NoticeViewPresenter";



    @Inject
    public NoticeViewPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }


    @Override
    public void delete(Board board) {
        Disposable d = getDataManager().deleteBoard(board)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item-> { Timber.d("delete:" + item.getClass().toString()); getAmandaView().onDeleteSuccess();});

        getCompositeDisposable().add(d);
    }



}
