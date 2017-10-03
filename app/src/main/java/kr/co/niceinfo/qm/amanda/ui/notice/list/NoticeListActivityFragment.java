package kr.co.niceinfo.qm.amanda.ui.notice.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;
import kr.co.niceinfo.qm.amanda.ui.notice.reg.NoticeRegActivity;

/**
 * A placeholder fragment containing a simple view.
 */

public class NoticeListActivityFragment extends BaseFragment implements NoticeListMvpView {

    private static final String TAG = "NoticeListFragment";

    @Inject
    NoticeListMvpPresenter<NoticeListMvpView> mPresenter;

    @Inject
    NoticeAdapter mNoticeAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.notice_recycler_view)
    RecyclerView noticeRecyclerView;

    @BindView(R.id.fb_notice_reg)
    FloatingActionButton fbNoticeReg;


    public static NoticeListActivityFragment newInstance() {
        Log.i(TAG, "[wychoi] newInstance");
        Bundle args = new Bundle();
        NoticeListActivityFragment fragment = new NoticeListActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "[wychoi] onCreateView");
        View view = inflater.inflate(R.layout.fragment_notice_list, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        Log.i(TAG, "[wychoi] setUp");
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        noticeRecyclerView.setLayoutManager(mLayoutManager);
        noticeRecyclerView.setItemAnimator(new DefaultItemAnimator());
        noticeRecyclerView.setAdapter(mNoticeAdapter);

        mPresenter.onViewPrepared();
    }

    @Override
    public void updateNotice(List<Board> boardList) {
        Log.i(TAG, "[wychoi] updateNotice : " + boardList.toString());
        mNoticeAdapter.addItems(boardList);
    }


    @Override
    public void onDestroyView() {
        Log.i(TAG, "[wychoi] onCreateView");
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    @OnClick(R.id.fb_notice_reg)
    public void openNoticeRegActivity() {
        Log.i(TAG, "[wychoi] openNoticeRegActivity");
        Intent intent = new Intent(getActivity(), NoticeRegActivity.class);
        startActivity(intent);
        getActivity().finish();
    }


    public NoticeAdapter getmNoticeAdapter() {
        return mNoticeAdapter;
    }

}
