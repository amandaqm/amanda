package kr.co.niceinfo.qm.amanda.ui.notice.list;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
    public List<Board> getBoards() {
        List<Board> boardList = new ArrayList<>();
        //error
        //Observable<Board> boardObservable = getDataManager().getBoards();
        //Log.i("getBoards",getDataManager().getBoards().toString());

        getDataManager().getBoards().subscribe(new Consumer<Board>() {
            @Override
            public void accept(@NonNull Board board) throws Exception {
                Log.i("PTgetBoards",board.toString());
            }

        });
        return boardList;
    }

    @Override
    public void onNoticeRegBtnClick() {
        Log.i(TAG, "onNoticeRegBtnClick");
        //getAmandaView().openBoardListActivity();
    }
}
