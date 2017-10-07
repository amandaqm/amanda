package kr.co.niceinfo.qm.amanda.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.User;
import kr.co.niceinfo.qm.amanda.presenter.RegisterMVP;
import kr.co.niceinfo.qm.amanda.presenter.impl.RegisterPresenter;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import timber.log.Timber;


public class RegisterActivity extends BaseActivity implements RegisterMVP.View {
    @Inject RegisterPresenter mPresenter;

    @BindView(R.id.email)  TextInputLayout mEmail;
    @BindView(R.id.password)  TextInputLayout mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("RegisterActivity onCreate");
        setContentView(R.layout.activity_register);
        getActivityComponent().inject(this);
        Timber.d("ActivityComponent() inject");
        setUnBinder(ButterKnife.bind(this));
        Timber.d("ButterKnife bind()");

        mPresenter.onAttach(this);
        Timber.d("RegisterPresenter onAttach");
    }

    // 로그인 화면의 회원가입 버튼 클릭 시
    @OnClick(R.id.register)
    void register(View v) {
        //회원가입
        User user = new User(mEmail.getEditText().getText().toString(),
                mPassword.getEditText().getText().toString());
        mPresenter.register(user);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    public static void startMe(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }

    @Override
    public void registerSuccess() {

    }
    @Override
    public void registerFailed() {

    }


    @Override
    protected void setUp() {

    }
}