package kr.co.niceinfo.qm.amanda.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import kr.co.niceinfo.qm.amanda.ui.main.MainActivity;


public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    // UI XML 자동 후킹
    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    // activity 이동을 위한 intent 반환
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ApplicationComponent와 ActivityModule이 셋팅된 ActivityComponent에 this(LoginActivity) 주입
        getActivityComponent().inject(this);
        //ButterKnife: View Inject 라이브러리
        //@BindView(R.id.et_password)와 같은 방식으로 어노테이션을 이용하여 UI 컴포넌트를 자동 후킹 할 수 있음.
        setUnBinder(ButterKnife.bind(this));
        //LoginMvpPresenter와 View 연결
        mPresenter.onAttach(LoginActivity.this);
    }

    // 로그인 화면의 로그인 버튼 클릭 시
    @OnClick(R.id.btn_server_login)
    void onServerLoginClick(View v) {
        //로그인 체크
        mPresenter.onServerLoginClick(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }

    //메인화면으로 이동
    @Override
    public void openMainActivity() {
        // 자신의 activity로 이동시키 위해 static으로 선언
        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}
