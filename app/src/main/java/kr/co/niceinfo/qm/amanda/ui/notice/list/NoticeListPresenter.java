package kr.co.niceinfo.qm.amanda.ui.notice.list;

import android.os.Looper;
import android.util.Log;

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
    public void getBoards() {
/*

        List<Board> boards = new ArrayList<>();
        Board board = new Board();
        board.setKey("NoticeListPresenter getBoards 추가1");
        board.setPostingTitle("NoticeListPresenter getBoards 추가1");
        boards.add(board);
        getAmandaView().refreshRecycleView(boards);
        Log.i(TAG, "UI 스레드 여부1 : "+ Looper.myLooper()+" : "+ Looper.getMainLooper());
*/

        getCompositeDisposable().add(getDataManager().getBoards()
                //.subscribeOn(getSchedulerProvider().io())
                .subscribeOn(getSchedulerProvider().io())
                //.observeOn(getSchedulerProvider().ui())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Board>>() {
                               @Override
                               public void accept(@NonNull List<Board> boardList) throws Exception {
                                   Log.i(TAG, boardList.toString());

                                   NoticeListActivityFragment.boardList.clear();
                                   NoticeListActivityFragment.boardList.addAll(boardList);
                                   //getAmandaView().refreshRecycleView(boardList);
                                   NoticeListActivityFragment.noticeAdapter.notifyDataSetChanged();;

                                   Log.i(TAG, "UI 스레드 여부2 : "+ Looper.myLooper()+" : "+ Looper.getMainLooper());

                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                               }
                           }
                ));
/*

        board = new Board();
        board.setKey("NoticeListPresenter getBoards 추가2");
        board.setPostingTitle("NoticeListPresenter getBoards 추가2");
        boards.add(board);
        getAmandaView().refreshRecycleView(boards);
        Log.i(TAG, "UI 스레드 여부3 : "+ Looper.myLooper()+" : "+ Looper.getMainLooper());
*/

    }

    @Override
    public void onNoticeRegBtnClick() {
        Log.i(TAG, "onNoticeRegBtnClick");
        //getAmandaView().openBoardListActivity();
    }
}
