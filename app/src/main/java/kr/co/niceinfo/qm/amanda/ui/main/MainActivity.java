package kr.co.niceinfo.qm.amanda.ui.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import kr.co.niceinfo.qm.amanda.ui.main.btnmenu.MainMenuFragment;

public class MainActivity extends BaseActivity implements MainMvpView {

    private static final String TAG = "MainActivity";

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ApplicationComponent와 ActivityModule이 셋팅된 ActivityComponent에 this(MainActivity) 주입
        getActivityComponent().inject(this);
        //ButterKnife: View Inject 라이브러리
        //@BindView(R.id.et_password)와 같은 방식으로 어노테이션을 이용하여 UI 컴포넌트를 자동 후킹 할 수 있음.
        setUnBinder(ButterKnife.bind(this));
        //MainMvpPresenter와 View 연결
        mPresenter.onAttach(MainActivity.this);
        setSupportActionBar(toolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.layout_mainmenu, MainMenuFragment.newInstance(), MainActivity.TAG)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.i(TAG, "onOptionsItemSelected" + id + "");
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mPresenter.onMenuItemSettingClick();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    //BaseActivity
    @Override
    protected void setUp() {

    }

}
