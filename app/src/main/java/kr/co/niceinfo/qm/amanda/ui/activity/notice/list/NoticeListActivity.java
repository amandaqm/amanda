package kr.co.niceinfo.qm.amanda.ui.activity.notice.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import kr.co.niceinfo.qm.amanda.ui.activity.notice.reg.NoticeRegActivity;

public class NoticeListActivity extends BaseActivity {

    private static final String TAG = "NoticeListActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fb_notice_reg)
    FloatingActionButton fbNoticeReg;

    // activity 이동을 위한 intent 반환
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, NoticeListActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);

        setUnBinder(ButterKnife.bind(this));
        setSupportActionBar(toolbar);

        //메뉴바에  <- 버튼 생성성
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    protected void setUp() {

    }


    @OnClick(R.id.fb_notice_reg)
    public void openNoticeRegActivity() {
        Log.i(TAG, "[wychoi] openNoticeRegActivity");
        Intent intent = new Intent(this, NoticeRegActivity.class);
        startActivity(intent);
        //getActivity().finish();
    }

}
