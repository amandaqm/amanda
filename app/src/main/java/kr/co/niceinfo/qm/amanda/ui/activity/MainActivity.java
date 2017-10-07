package kr.co.niceinfo.qm.amanda.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Method;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.presenter.MainMVP;
import kr.co.niceinfo.qm.amanda.presenter.impl.MainPresenter;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import kr.co.niceinfo.qm.amanda.ui.fragment.btnmenu.MainMenuFragment;
import timber.log.Timber;


public class MainActivity extends BaseActivity implements MainMVP.View {

    private static final String TAG = "MainActivity";

    @Inject
    MainPresenter mPresenter;


   @BindView(R.id.toolbar)
   Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_fire_alarm_36dp);


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
        if(menu.getClass().getSimpleName().equals("MenuBuilder")){
            try{
                Method m = menu.getClass().getDeclaredMethod(
                        "setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                Timber.e(e, "onMenuOpened");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id) {
            case R.id.action_settings: {
                mPresenter.onMenuItemSettingsClick(this);
                return true;
            }
            case R.id.action_notice_list: {
                mPresenter.onMenuItemNoticeListClick(this);
                return true;
            }

        }



        return super.onOptionsItemSelected(item);
    }


    public static void startMe(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }

    //BaseActivity
    @Override
    protected void setUp() {

    }




}
