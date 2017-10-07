package kr.co.niceinfo.qm.amanda.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.presenter.OnBoardingMVP;
import kr.co.niceinfo.qm.amanda.presenter.impl.OnBoardingPresenter;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;


public class OnBoardingActivity extends BaseActivity implements OnBoardingMVP.View {
    @Inject  OnBoardingPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
    }

    //로그인 버튼 클릭 시
    @OnClick(R.id.login)
    void login() {
        mPresenter.goToLogin(this);
        finish();
    }


    // 로그인 화면의 회원가입 버튼 클릭 시
    @OnClick(R.id.register)
    void register() {
        mPresenter.goToRegister(this);
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    public static void startMe(Context context) {
        Intent intent = new Intent(context, OnBoardingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }


    @Override
    protected void setUp() {

    }

}