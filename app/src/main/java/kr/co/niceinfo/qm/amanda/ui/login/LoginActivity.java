package kr.co.niceinfo.qm.amanda.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import kr.co.niceinfo.qm.amanda.ui.main.MainActivity;


public class LoginActivity extends BaseActivity implements LoginMvpView {


    private static final String TAG = "LoginActivity";

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    // UI XML 자동 후킹
    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    @BindView(R.id.spn_department)
    Spinner mspnDepartment;

    @BindView(R.id.spn_position)
    Spinner mspnPosition;

    @BindView(R.id.spn_duty)
    Spinner mspnDuty;

    @BindView(R.id.ll_signin)
    LinearLayout ll_signin;


    @BindView(R.id.btn_server_login)
    Button btnServerLogin;

    @BindView(R.id.btn_register)
    Button btnRegister;

    @BindView(R.id.btn_cancel)
    Button btnCancel;

    @BindView(R.id.btn_sign_in)
    Button btnSignIn;


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

    @Override
    protected void setUp() {

        mspnDepartment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "view:" + view + "/ position : " + position + "/ id:" + id);
            }
        });

        mspnPosition.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "view:" + view + "/ position : " + position + "/ id:" + id);
            }
        });

        mspnDuty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "view:" + view + "/ position : " + position + "/ id:" + id);
            }
        });


    }

    //로그인 버튼 클릭 시
    @OnClick(R.id.btn_server_login)
    void onServerLoginClick(View v) {
        User user = new User(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
        Log.i(TAG, "" + user.toString());
        mPresenter.onServerLoginClick(user);
    }

    //가입버튼 클릭 시
    @OnClick(R.id.btn_register)
    void onClickBtnRegister(View v) {
        Log.i(TAG, "onClickBtnRegister");
        btnServerLogin.setVisibility(View.GONE);
        btnRegister.setVisibility(View.GONE);
        ll_signin.setVisibility(View.VISIBLE);
    }

    //
    @OnClick(R.id.btn_cancel)
    void onClickBtnCancel(View v) {
        Log.i(TAG, "onClickBtnCancel");
        btnServerLogin.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.VISIBLE);
        ll_signin.setVisibility(View.GONE);
    }


    // 로그인 화면의 회원가입 버튼 클릭 시
    @OnClick(R.id.btn_sign_in)
    void onRegisterUser(View v) {
        //회원가입
        User user = new User(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
        Log.i(TAG, "" + user.toString());
        mPresenter.onRegisterUser(user);
    }


    //메인화면으로 이동
    @Override
    public void openMainActivity() {
        // 자신의 activity로 이동

        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


}