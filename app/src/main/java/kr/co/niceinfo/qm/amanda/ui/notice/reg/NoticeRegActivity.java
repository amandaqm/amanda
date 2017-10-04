package kr.co.niceinfo.qm.amanda.ui.notice.reg;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.google.gson.JsonObject;

import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;


public class NoticeRegActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_reg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //메뉴바에  <- 버튼 생성성
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    protected void setUp() {

    }
    //Acticity에서 Fragment로 데이터 전달
    protected JsonObject getData(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("notice_type",getIntent().getStringExtra("notice_type"));
        jsonObject.addProperty("notice_key",getIntent().getStringExtra("notice_key"));
        return  jsonObject;
    }
}

