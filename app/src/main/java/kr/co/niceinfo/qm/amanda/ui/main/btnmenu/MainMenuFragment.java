package kr.co.niceinfo.qm.amanda.ui.main.btnmenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;


public class MainMenuFragment extends BaseFragment implements MainMenuMvpView {

    private static final String TAG = "MainMenuFragment";

    @Inject
    MainMenuMvpPresenter<MainMenuMvpView> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.btn_rule)
    Button mBtnRule;

    @BindView(R.id.btn_chat)
    Button mBtnChat;

    @BindView(R.id.btn_contact)
    Button mBtnContact;


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
        return view;
    }


    @OnClick(R.id.btn_rule)
    public void onRuleBtnClick(View v) {
        Log.i(TAG, "onRuleBtnClick" );
        mPresenter.onRuleBtnClick();
    }


    @OnClick(R.id.btn_chat)
    public void onChatBtnClick(View v) {
        Log.i(TAG, "onChatBtnClick" );
        mPresenter.onChatBtnClick();
    }


    @OnClick(R.id.btn_contact)
    public void onContactBtnClick(View v) {
        Log.i(TAG, "onContactBtnClick" );
        mPresenter.onContactBtnClick();
    }


    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

}
