package kr.co.niceinfo.qm.amanda.ui.main;

import android.util.Log;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.ui.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

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
        Log.i(TAG, "onMenuItemSettingClick");

    }
}
