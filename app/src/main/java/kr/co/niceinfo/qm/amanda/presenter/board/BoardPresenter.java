package kr.co.niceinfo.qm.amanda.presenter.board;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.ui.activity.board.BoardMvpView;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public class BoardPresenter<V extends BoardMvpView> extends BasePresenter<V>
        implements BoardMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";


    @Inject
    public BoardPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }



}
