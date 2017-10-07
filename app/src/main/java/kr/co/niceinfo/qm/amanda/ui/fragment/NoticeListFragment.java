package kr.co.niceinfo.qm.amanda.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.presenter.NoticeListMVP;
import kr.co.niceinfo.qm.amanda.presenter.impl.NoticeListPresenter;
import kr.co.niceinfo.qm.amanda.ui.adapter.NoticeListAdapter;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;
import kr.co.niceinfo.qm.amanda.ui.event.NoticeViewEvent;


public class NoticeListFragment extends BaseFragment implements NoticeListMVP.View {

    public static final String TAG = NoticeListFragment.class.getName();

    OnChangeFragment onChangeFragment;

    @Inject NoticeListPresenter mPresenter;
    @BindView(R.id.notice_recycler_view) RecyclerView mNoticeRecyclerView;


    private NoticeListAdapter mNoticeListAdapter;



    public NoticeListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment TransactionsFragment.
     */
    public static NoticeListFragment newInstance() {
        NoticeListFragment fragment = new NoticeListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnChangeFragment) {
            onChangeFragment = (OnChangeFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChangeFragment");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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

        mPresenter.getDataManager().getBoards().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(item-> {
                mNoticeListAdapter.clear();
                mNoticeListAdapter.addAll(item);
                mNoticeListAdapter.notifyDataSetChanged();
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mNoticeRecyclerView.setLayoutManager(llm);


        mNoticeListAdapter = new NoticeListAdapter(getContext());
        mNoticeRecyclerView.setAdapter(mNoticeListAdapter);
        mNoticeListAdapter.getPublishSubject().subscribe(s-> {
            EventBus.getDefault().postSticky(new NoticeViewEvent(s));
            onChangeFragment.onChangeFragment(NoticeViewFragment.TAG);

        });

    }



    @Override
    protected void setUp(View view) {

    }
}