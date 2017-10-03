package kr.co.niceinfo.qm.amanda.ui.main.btnmenu;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.ui.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public class MainMenuPresenter<V extends MainMenuMvpView> extends BasePresenter<V>
        implements MainMenuMvpPresenter<V> {

    private static final String TAG = "MainMenuPresenter";

    @Inject
    public MainMenuPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    //로그인 사용자 이메일 주소 반환
    public String getInteralMail() {
        return getDataManager().getCurrentUserEmail();
    }

    //수칙 버튼 클릭
    @Override
    public void onRuleBtnClick() {
        Log.i(TAG, "onRuleBtnClick");
        //getAmandaView() 를 이용해서 View에게 값을 넘겨줌.
        getAmandaView().openFeedActivity();
    }

    //채팅버튼
    @Override
    public void onChatBtnClick() {
        Log.i(TAG, "onChatBtnClick");

    }

    //비상연락망 버튼
    @Override
    public void onContactBtnClick() {
        Log.i(TAG, "onContactBtnClick");

    }

    @Override
    public void onNoticeBtnClick() {
        Log.i(TAG, "onNoticeBtnClick");
        getAmandaView().openBoardListActivity();
    }
}
