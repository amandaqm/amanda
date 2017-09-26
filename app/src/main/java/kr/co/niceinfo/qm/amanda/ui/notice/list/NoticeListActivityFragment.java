package kr.co.niceinfo.qm.amanda.ui.notice.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;
import kr.co.niceinfo.qm.amanda.ui.notice.reg.NoticeRegActivity;

/**
 * A placeholder fragment containing a simple view.
 */

public class NoticeListActivityFragment extends BaseFragment implements NoticeListMvpView {

    private static final String TAG = "NoticeListFragment";
    NoticeAdapter noticeAdapter = null;
    List<Board> boardList = new ArrayList<>();

    @Inject
    NoticeListMvpPresenter<NoticeListMvpView> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.notice_List_root_view)
    ConstraintLayout noticeListRootView;

    @BindView(R.id.notice_recycler_view)
    RecyclerView noticeRecyclerView;

    @BindView(R.id.fb_notice_reg)
    FloatingActionButton fbNoticeReg;


    public NoticeListActivityFragment() {
    }

    public static NoticeListActivityFragment newInstance() {
        Bundle args = new Bundle();
        NoticeListActivityFragment fragment = new NoticeListActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_list, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }

        noticeAdapter =  new NoticeAdapter(boardList, getActivity());
        noticeRecyclerView.setAdapter(noticeAdapter);
        noticeRecyclerView.setLayoutManager(mLayoutManager);
        mPresenter.getBoards();

        return view;
    }

    public List<Board> getBoardList(){
        //boardList.clear();
        return boardList;
    }

    public void refreshRecycleView(){
        noticeAdapter.notifyDataSetChanged();
    }





    @Override
    @OnClick(R.id.fb_notice_reg)
    public void openNoticeRegActivity() {
        Log.i(TAG, "openNoticeRegActivity");

        Intent intent = new Intent(getActivity(), NoticeRegActivity.class);
        startActivity(intent);
        //getActivity().finish();

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

    @Override
    public void onError(String message) {
        super.onError(message);
    }

    @Override
    public void onError(@StringRes int resId) {
        super.onError(resId);
    }

    @Override
    public void showMessage(String message) {
        super.showMessage(message);
    }

    @Override
    public void showMessage(@StringRes int resId) {
        super.showMessage(resId);
    }

    @Override
    public boolean isNetworkConnected() {
        return super.isNetworkConnected();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        super.hideKeyboard();
    }

    @Override
    public void openActivityOnTokenExpire() {
        super.openActivityOnTokenExpire();
    }

    @Override
    public ActivityComponent getActivityComponent() {
        return super.getActivityComponent();
    }

    @Override
    public BaseActivity getBaseActivity() {
        return super.getBaseActivity();
    }

    @Override
    public void setUnBinder(Unbinder unBinder) {
        super.setUnBinder(unBinder);
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
