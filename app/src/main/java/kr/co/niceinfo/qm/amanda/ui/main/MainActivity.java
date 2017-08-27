package kr.co.niceinfo.qm.amanda.ui.main;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.ui.base.AmandaView;
import kr.co.niceinfo.qm.amanda.ui.base.BaseActivity;
import kr.co.niceinfo.qm.amanda.ui.login.LoginActivity;

public class MainActivity extends BaseActivity implements AmandaView, MainMenuFragment.OnFragmentInteractionListener{

    private static final String TAG = "MainActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    //BaseActivity
    @Override
    protected void setUp() {

    }

    //MainMenuFragment.OnFragmentInteractionListener
    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.i(TAG, "onFragmentInteraction Uri:" + uri.toString());
    }
}
