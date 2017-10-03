package kr.co.niceinfo.qm.amanda.ui.notice.reg;

import android.util.Log;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.ui.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public class NoticeRegPresenter<V extends NoticeRegMvpView> extends BasePresenter<V>
        implements NoticeRegMvpPresenter<V> {

    private static final String TAG = "NoticeRegPresenter";


    @Inject
    public NoticeRegPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    //Notice 등록
    public Board regNotice(Board notice) {
        Log.i(TAG, "regNotice: " + notice.toString());
        getAmandaView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .insertBoard(notice)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Object>() {
                               @Override
                               public void accept(@NonNull Object objects) throws Exception {
                                   Log.i(TAG, "regNotice : " + objects.toString());
                                   if (!((Board) objects).getKey().equals("")) {
                                       getAmandaView().openNoticeListActivity();
                                   }
                                   getAmandaView().hideLoading();
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(@NonNull Throwable throwable)
                                       throws Exception {
                                   if (!isViewAttached()) {
                                       return;
                                   }
                                   getAmandaView().hideLoading();

                                   // handle the error here
                                   if (throwable instanceof ANError) {
                                       ANError anError = (ANError) throwable;
                                       handleApiError(anError);
                                   }
                               }
                           }
                ));

        return notice;
    }

}
