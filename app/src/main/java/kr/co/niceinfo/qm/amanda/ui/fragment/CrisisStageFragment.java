package kr.co.niceinfo.qm.amanda.ui.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.presenter.CrisisStageMVP;
import kr.co.niceinfo.qm.amanda.presenter.impl.CrisisStagePresenter;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;


public class CrisisStageFragment extends BaseFragment implements CrisisStageMVP.View {

    public static final String TAG = CrisisStageFragment.class.getName();



    @Inject CrisisStagePresenter mPresenter;


    @BindView(R.id.service_stage) TextView mServiceStage;
    @BindView(R.id.service_stage_desc) TextView mServiceStageDesc;
    @BindView(R.id.security_stage) TextView mSecurityStage;
    @BindView(R.id.security_stage_desc) TextView mSecurityStageDesc;


    public CrisisStageFragment() {

    }


    public static CrisisStageFragment newInstance() {
        CrisisStageFragment fragment = new CrisisStageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityComponent component = getActivityComponent();
        component.inject(this);
        mPresenter.onAttach(this);

        // orientation change 문제 해결을 위해서
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crisis_stage, container, false);
        setUnBinder(ButterKnife.bind(this, view));
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.show();
    }

    @Override
    public void service(String level, Date date, String desc) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm");
        mServiceStage.setText(level + "\n" + sdf.format(date));
        if (level.equals("심각")) {
            mServiceStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_red_circle_48dp, 0, 0, 0);
        }
        else if (level.equals("경계")) {
            mServiceStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_orange_circle_48dp, 0, 0, 0);
        }
        else if (level.equals("주의")) {
            mServiceStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_yellow_circle_48dp, 0, 0, 0);
        }
        else if (level.equals("관심")) {
            mServiceStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_blue_circle_48dp, 0, 0, 0);
        }
        else {
            mServiceStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_green_circle_48dp, 0, 0, 0);
        }
        mServiceStageDesc.setText(Html.fromHtml(desc));
    }

    @Override
    public void security(String level, Date date, String desc) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm");
        mSecurityStage.setText(level + "\n" + sdf.format(date));
        if (level.equals("심각")) {
            mSecurityStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_red_circle_48dp, 0, 0, 0);
        }
        else if (level.equals("경계")) {
            mSecurityStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_orange_circle_48dp, 0, 0, 0);
        }
        else if (level.equals("주의")) {
            mSecurityStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_yellow_circle_48dp, 0, 0, 0);
        }
        else if (level.equals("관심")) {
            mSecurityStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_blue_circle_48dp, 0, 0, 0);
        }
        else {
            mSecurityStage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_green_circle_48dp, 0, 0, 0);
        }
        mSecurityStageDesc.setText(Html.fromHtml(desc));
    }



    @OnClick(R.id.service_stage)
    public void service() {

    }


    @OnClick(R.id.security_stage)
    public void security() {

    }



    @Override
    protected void setUp(View view) {

    }
}