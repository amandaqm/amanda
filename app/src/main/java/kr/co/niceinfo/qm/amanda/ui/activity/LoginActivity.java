package kr.co.niceinfo.qm.amanda.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.presenter.LoginMVP;
import kr.co.niceinfo.qm.amanda.presenter.impl.LoginPresenter;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;


public class LoginActivity extends BaseActivity implements LoginMVP.View {
    @Inject LoginPresenter mPresenter;

    @BindView(R.id.email)   TextInputLayout mEmail;
    @BindView(R.id.password)  TextInputLayout mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
    }

    //로그인 버튼 클릭 시
    @OnClick(R.id.login)
    void login() {
        User user = new User(mEmail.getEditText().getText().toString(),
                mPassword.getEditText().getText().toString());
        mPresenter.login(user);
    }


    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    public static void startMe(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }

    @Override
    public void loginSuccess() {
        mPresenter.goToMain(this);
        finish();
    }
    @Override
    public void loginFailed() {

    }


    @Override
    protected void setUp() {

    }
}