package kr.co.niceinfo.qm.amanda.ui.main;

import android.util.Log;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.ui.base.BasePresenter;


public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(
            // DataManager dataManager,
            // SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        //super(dataManager, schedulerProvider, compositeDisposable);
        super(compositeDisposable);
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    @Override
    public void onAttach(V AmandaView) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void handleApiError(ANError error) {

    }

    @Override
    public void onMenuItemSettingClick() {
        Log.i(TAG, "onMenuItemSettingClick" );

    }
}
