package kr.co.niceinfo.qm.amanda.ui.main.btnmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;
import kr.co.niceinfo.qm.amanda.ui.login.LoginActivity;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListActivity;


public class MainMenuFragment extends BaseFragment implements MainMenuMvpView {

    private static final String TAG = "MainMenuFragment";

    @Inject
    MainMenuMvpPresenter<MainMenuMvpView> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;


    @BindView(R.id.tv_InteralMail)
    TextView mInteralMail;

    @BindView(R.id.btn_rule)
    Button mBtnRule;

    @BindView(R.id.btn_chat)
    Button mBtnChat;

    @BindView(R.id.btn_contact)
    Button mBtnContact;

    @BindView(R.id.btn_notice)
    Button mBtnNotice;


    public static MainMenuFragment newInstance() {
        Bundle args = new Bundle();
        MainMenuFragment fragment = new MainMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            //mBlogAdapter.setCallback(this);
        }

        mInteralMail.setText("로그인 계정(이메일): " + mPresenter.getInteralMail());
        return view;
    }


    @OnClick(R.id.btn_rule)
    public void onRuleBtnClick(View v) {
        Log.i(TAG, "onRuleBtnClick");
        mPresenter.onRuleBtnClick();
    }


    @OnClick(R.id.btn_chat)
    public void onChatBtnClick(View v) {
        Log.i(TAG, "onChatBtnClick");
        mPresenter.onChatBtnClick();
    }

    @OnClick(R.id.btn_contact)
    public void onContactBtnClick(View v) {
        Log.i(TAG, "onContactBtnClick");
        mPresenter.onContactBtnClick();
    }

    @OnClick(R.id.btn_notice)
    public void onNoticeBtnClick(View v) {
        Log.i(TAG, "onNoticeBtnClick");
        mPresenter.onNoticeBtnClick();
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void openLoginActivity() {
        //테스트. 버튼 클릭 시 로그인 화면으로 이동
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void openBoardListActivity() {
        //테스트. 버튼 클릭 시 로그인 화면으로 이동
        Intent intent = new Intent(getActivity(), NoticeListActivity.class);
        startActivity(intent);
        //getActivity().finish();
    }

}
