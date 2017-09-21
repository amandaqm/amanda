package kr.co.niceinfo.qm.amanda.ui.notice.reg;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
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
    public Board regNotice(Board notice)
    {
        Log.i(TAG, "regNotice: " + notice.toString());
        getDataManager().insertBoard(notice);

        return notice;
    }

}
