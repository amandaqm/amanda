package kr.co.niceinfo.qm.amanda.ui.notice.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;

public class NoticeListActivity extends BaseActivity {

    private static final String TAG = "NoticeListActivity";

    @BindView(R.id.toolbar)
    Toolbar toolbar;



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

    }

    @Override
    protected void setUp() {

    }

}
