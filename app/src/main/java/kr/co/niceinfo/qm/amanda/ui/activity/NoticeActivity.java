package kr.co.niceinfo.qm.amanda.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;
import kr.co.niceinfo.qm.amanda.ui.event.NoticeRegisterEvent;
import kr.co.niceinfo.qm.amanda.ui.fragment.NoticeEditFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.NoticeListFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.NoticeRegisterFragment;
import kr.co.niceinfo.qm.amanda.ui.fragment.NoticeViewFragment;
import timber.log.Timber;


public class NoticeActivity extends BaseActivity implements BaseFragment.OnChangeFragment  {

    @BindView(R.id.root_view) CoordinatorLayout rootView;

    private String currentFragmentTag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        setUnBinder(ButterKnife.bind(this));
        initFragment(NoticeListFragment.TAG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notice, menu);
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

                return true;
            }
            case R.id.action_notice_register: {
                EventBus.getDefault().postSticky(new NoticeRegisterEvent(new Board()));
                initFragment(NoticeRegisterFragment.TAG);
                return true;
            }

        }



        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public static void startMe(Context context) {
        Intent intent = new Intent(context, NoticeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }



    @Override
    protected void setUp() {

    }


    private void initFragment(String fragmentTag) {
        currentFragmentTag = fragmentTag;
        Fragment fragment = getFragment(fragmentTag);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, getFragment(fragmentTag));


        fragmentTransaction.replace(R.id.content_frame, fragment).commit();
    }

    private Fragment getFragment(String fragmentTag) {

        if (fragmentTag.equals(NoticeViewFragment.TAG)) {
            return NoticeViewFragment.newInstance();
        }
        else if (fragmentTag.equals(NoticeEditFragment.TAG)) {
            return NoticeEditFragment.newInstance();
        }
        else if (fragmentTag.equals(NoticeRegisterFragment.TAG)) {
            return NoticeRegisterFragment.newInstance();
        }
        else {
            return NoticeListFragment.newInstance();
        }
    }

    @Override
    public void onChangeFragment(String fragmentTag) {

        initFragment(fragmentTag);
    }

    @Override
    public void onBackPressed() {
        if (!currentFragmentTag.equals(NoticeListFragment.TAG)) {
            initFragment(NoticeListFragment.TAG);
        }
        else {
            finish();
        }
    }


}