package kr.co.niceinfo.qm.amanda.ui.notice.list;

import android.util.Log;

import com.androidnetworking.error.ANError;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.ui.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public class NoticeListPresenter<V extends NoticeListMvpView> extends BasePresenter<V>
        implements NoticeListMvpPresenter<V> {

    private static final String TAG = "NoticeListPresenter";

    @Inject
    public NoticeListPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    //로그인 사용자 이메일 주소 반환
    public String getInteralMail() {
        return getDataManager().getCurrentUserEmail();
    }

    @Override
    public void onViewPrepared() {
        //getAmandaView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getBoards()
                .subscribeOn(getSchedulerProvider().io())
                //.observeOn(getSchedulerProvider().ui())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Board>>() {
                               @Override
                               public void accept(@NonNull List<Board> boardList) throws Exception {
                                   Log.i(TAG, boardList.toString());

                                   if (boardList != null) {
                                       getAmandaView().updateNotice(boardList);
                                   }
                                   //getAmandaView().hideLoading();
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(@NonNull Throwable throwable)
                                       throws Exception {
                                   if (!isViewAttached()) {
                                       return;
                                   }
                                   //getAmandaView().hideLoading();

                                   // handle the error here
                                   if (throwable instanceof ANError) {
                                       ANError anError = (ANError) throwable;
                                       handleApiError(anError);
                                   }
                               }
                           }
                ));
    }

    @Override
    public void onNoticeRegBtnClick() {
        Log.i(TAG, "onNoticeRegBtnClick");
        //getAmandaView().openBoardListActivity();
    }
}
