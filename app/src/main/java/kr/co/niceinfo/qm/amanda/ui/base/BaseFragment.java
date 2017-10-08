package kr.co.niceinfo.qm.amanda.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.google.gson.JsonObject;

import butterknife.Unbinder;
import kr.co.niceinfo.qm.amanda.BuildConfig;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.data.network.NetworkTask;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.utils.CommonUtils;

public abstract class BaseFragment extends Fragment implements AmandaView {

    private BaseActivity mActivity;
    private Unbinder mUnBinder;
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this.getContext());
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    public ActivityComponent getActivityComponent() {
        if (mActivity != null) {
            return mActivity.getActivityComponent();
        }
        return null;
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract void setUp(View view);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
    }

    public interface Callback {
        void onFragmentAttached();
        void onFragmentDetached(String tag);
    }

    public interface OnChangeFragment {
        void onChangeFragment(String fragmentTag);
    }

    //FCM PUSH & NOTI
    public void fcmPushNoti(String topic, Object obj) {

        String url = BuildConfig.FCM_BASE_URL;

        if (topic.equals("notice") && obj instanceof Board) {
            // URL 설정
            url = url + "/fcm/send";
            Board notice = (Board) obj;

            //noti 정보
            JsonObject notificationObj = new JsonObject();
            notificationObj.addProperty("title", notice.getPostingTitle());
            notificationObj.addProperty("body", notice.getPostingContent());

            //data로 넘길 정보
            JsonObject dataObj = new JsonObject();
            dataObj.addProperty("postingTitle", notice.getPostingTitle());
            dataObj.addProperty("postingContent", notice.getPostingContent());
            dataObj.addProperty("key", notice.getKey());
            dataObj.addProperty("nofificationYn", notice.getNofificationYn());
            dataObj.addProperty("regDt", notice.getRegDt().toString());

            //FCM param
            JsonObject paramJsonObj = new JsonObject();
            paramJsonObj.addProperty("to", "/topics/"+topic);   //topic
            paramJsonObj.add("notification", notificationObj);
            paramJsonObj.add("data", dataObj);
            //String input = "{\"notification\" : {\"title\" : \" 여기다 제목넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\"/topics/notice\" , \"data\" : {\"message\" : \"제목\",}}";

            NetworkTask networkTask = new NetworkTask(url, paramJsonObj);
            networkTask.execute();
        }
    }

}
