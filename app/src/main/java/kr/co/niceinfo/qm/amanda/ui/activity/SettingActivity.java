package kr.co.niceinfo.qm.amanda.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import cn.pedant.SweetAlert.SweetAlertDialog;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Member;
import kr.co.niceinfo.qm.amanda.presenter.SettingMVP;
import kr.co.niceinfo.qm.amanda.presenter.impl.SettingPresenter;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import timber.log.Timber;

import static kr.co.niceinfo.qm.amanda.R.id.tel;


public class SettingActivity extends BaseActivity implements SettingMVP.View {
    @Inject SettingPresenter mPresenter;

    @BindView(R.id.department) Spinner mDepartment;
    @BindView(R.id.name)    TextInputLayout mName;
    @BindView(tel)    TextInputLayout mTel;
    @BindView(R.id.etel)    TextInputLayout mEtel;


    private FirebaseAuth mAuth;
    // 부서명
    private String mDname = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("SettingActivity onCreate");
        setContentView(R.layout.activity_setting);
        getActivityComponent().inject(this);
        Timber.d("ActivityComponent() inject");
        setUnBinder(ButterKnife.bind(this));
        Timber.d("ButterKnife bind()");
        mAuth = FirebaseAuth.getInstance();
        mPresenter.onAttach(this);
        mPresenter.loadMember(mAuth.getCurrentUser().getUid());
    }

    @OnItemSelected(R.id.department)
    public void spinnerItemSelected(Spinner spinner, int position) {
        mDname = (String)spinner.getItemAtPosition(position);
    }





    // 로그인 화면의 회원가입 버튼 클릭 시
    @OnClick(R.id.update)
    void update() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mPresenter.update(new Member(currentUser.getUid(),mName.getEditText().getText().toString(),mDname,currentUser.getEmail(),mTel.getEditText().getText().toString(),mEtel.getEditText().getText().toString()));
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    public static void startMe(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }

    @Override
    public void updateSuccess() {
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setContentText("수정하였습니다")
                .setTitleText(getResources().getString(R.string.app_name))
                .setCustomImage(R.mipmap.ic_launcher)
                .setConfirmText("확인")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        finish();
                    }
                })
                .show();

    }
    @Override
    public void updateFailed() {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setContentText("실패하였습니다")
                .setTitleText(getResources().getString(R.string.app_name))
                .setCustomImage(R.mipmap.ic_launcher)
                .setConfirmText("확인")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .show();
    }



    @Override
    public void loadSuccess(Member member) {

        int idx = getIndex(mDepartment, member.getDepartment());
        mDepartment.setSelection(idx);

        mName.getEditText().setText(member.getName());
        mTel.getEditText().setText(member.getTel());
        mEtel.getEditText().setText(member.getEtel());
    }

    @Override
    public void loadFailed() {

    }


    @Override
    protected void setUp() {

    }



    private int getIndex(Spinner spinner, String searchString) {

        if (searchString == null || spinner.getCount() == 0) {

            return -1; // Not found

        }
        else {

            for (int i = 0; i < spinner.getCount(); i++) {
                String s = spinner.getItemAtPosition(i).toString();
                Timber.d("s:[" + s + "],[" + searchString + "]");
                if (s.equals(searchString)) {
                    return i; // Found!
                }
            }

            return -1; // Not found
        }
    };
}