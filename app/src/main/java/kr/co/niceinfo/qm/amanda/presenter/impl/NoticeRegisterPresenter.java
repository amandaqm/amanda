package kr.co.niceinfo.qm.amanda.presenter.impl;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.presenter.NoticeRegisterMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public final class NoticeRegisterPresenter extends BasePresenter<NoticeRegisterMVP.View> implements NoticeRegisterMVP.Presenter {

    private static final String TAG = "NoticeRegisterPresenter";


    @Inject
    public NoticeRegisterPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    @Override
    public void register(Board board) {
        Disposable d = getDataManager().insertBoard(board)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item-> getAmandaView().onRegisterSuccess());

        getCompositeDisposable().add(d);
    }

    //notice push & noti
    @Override
    public void postNotice(Board notice) {
        Log.i(TAG, "getNoticeInfo - noticeKey: " + notice);
        getCompositeDisposable().add(getDataManager()
                .postPushNoticeApiCall(notice)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Object>() {
                               @Override
                               public void accept(@NonNull Object obj) throws Exception {
                                   Log.i(TAG, "getNoticeInfo : " + obj);
                                   // notice push & noti 결과
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(@NonNull Throwable throwable) throws Exception {

                               }
                           }
                ));
    }



}
