package kr.co.niceinfo.qm.amanda.ui.base;

import android.util.Log;

import com.androidnetworking.common.ANConstants;
import com.androidnetworking.error.ANError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import io.reactivex.disposables.CompositeDisposable;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.network.model.ApiError;
import kr.co.niceinfo.qm.amanda.utils.AppConstants;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the AmandaView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends AmandaView> implements AmandaPresenter<V> {

    private static final String TAG = "BasePresenter";

    //private final DataManager mDataManager;
    //private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    private V mAmandaView;

    @Inject
    public BasePresenter(//DataManager dataManager,
                         //SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        //this.mDataManager = dataManager;
        //this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V amandaView) {
        mAmandaView = amandaView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mAmandaView = null;
    }

    public boolean isViewAttached() {
        return mAmandaView != null;
    }

    public V getAmandaView() {
        return mAmandaView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    //public DataManager getDataManager() {        return mDataManager;    }

    //public SchedulerProvider getSchedulerProvider() {        return mSchedulerProvider;    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void handleApiError(ANError error) {

        if (error == null || error.getErrorBody() == null) {
            //getAmandaView().onError(R.string.api_default_error);
            getAmandaView().onError("R.string.api_default_error");
            return;
        }

        if (error.getErrorCode() == AppConstants.API_STATUS_CODE_LOCAL_ERROR
                && error.getErrorDetail().equals(ANConstants.CONNECTION_ERROR)) {
            getAmandaView().onError(R.string.connection_error);
            return;
        }

        if (error.getErrorCode() == AppConstants.API_STATUS_CODE_LOCAL_ERROR
                && error.getErrorDetail().equals(ANConstants.REQUEST_CANCELLED_ERROR)) {
            getAmandaView().onError(R.string.api_retry_error);
            return;
        }

        final GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        try {
            ApiError apiError = gson.fromJson(error.getErrorBody(), ApiError.class);

            if (apiError == null || apiError.getMessage() == null) {
                getAmandaView().onError(R.string.api_default_error);
                return;
            }

            switch (error.getErrorCode()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    setUserAsLoggedOut();
                    getAmandaView().openActivityOnTokenExpire();
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                case HttpsURLConnection.HTTP_NOT_FOUND:
                default:
                    getAmandaView().onError(apiError.getMessage());
            }
        } catch (JsonSyntaxException | NullPointerException e) {
            Log.e(TAG, "handleApiError", e);
            getAmandaView().onError(R.string.api_default_error);
        }
    }

    @Override
    public void setUserAsLoggedOut() {
        //getDataManager().setAccessToken(null);
        }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(AmandaView) before" +
                    " requesting data to the Presenter");
        }
    }
}
