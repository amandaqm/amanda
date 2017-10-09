package kr.co.niceinfo.qm.amanda.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.presenter.NoticeRegisterMVP;
import kr.co.niceinfo.qm.amanda.presenter.impl.NoticeRegisterPresenter;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;
import kr.co.niceinfo.qm.amanda.ui.event.NoticeRegisterEvent;
import kr.co.niceinfo.qm.amanda.utils.ViewUtils;


public class NoticeRegisterFragment extends BaseFragment implements NoticeRegisterMVP.View {

    public static final String TAG = NoticeRegisterFragment.class.getName();


    @BindView(R.id.notice_content)
    EditText mNoticeContent;
    @BindView(R.id.notice_title)
    EditText mNoticeTitle;
    @BindView(R.id.notice_regdt)
    TextView mNoticeRegdt;
    @BindView(R.id.notificationYn)
    CheckBox mNofificationYn;

    @BindView(R.id.register)
    Button mRegister;

    @Inject
    NoticeRegisterPresenter mPresenter;
    OnChangeFragment onChangeFragment;
    Board mBoard;

    public NoticeRegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TransactionsFragment.
     */
    public static NoticeRegisterFragment newInstance() {
        NoticeRegisterFragment fragment = new NoticeRegisterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnChangeFragment) {
            onChangeFragment = (OnChangeFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChangeFragment");
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_register, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onNoticeRegisterEvent(NoticeRegisterEvent e) {
        mBoard = e.getBoard();
        mNoticeTitle.setText(e.getBoard().getPostingTitle());
        mNoticeContent.setText(e.getBoard().getPostingContent());
        mNoticeRegdt.setText(ViewUtils.standard(e.getBoard().getRegDt()));
    }


    @OnClick(R.id.register)
    public void register() {
        new SweetAlertDialog(getActivity(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setContentText("등록하시겠습니까?")
                .setTitleText(getResources().getString(R.string.app_name))
                .setCustomImage(R.mipmap.ic_launcher)
                .setConfirmText("예")
                .setCancelText("아니오")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        mBoard.setPostingTitle(mNoticeTitle.getText().toString());
                        mBoard.setPostingContent(mNoticeContent.getText().toString());
                        mBoard.setNofificationYn(mNofificationYn.isChecked() == true ? "Y" : "N");
                        mPresenter.register(mBoard);
                    }
                })
                .show();
    }


    @Override
    protected void setUp(View view) {

    }


    public void onRegisterSuccess() {
        //매개변수로 mBoard 받는 방식으로 변경하기
        if (mBoard.getNofificationYn().equals("Y")) {
            //rx
            mPresenter.postNotice(mBoard);

            //FCM PUSH & NOTI- 일반 http 이용
            //fcmPushNoti("notice", mBoard);
        }

        new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE)
                .setContentText("등록하였습니다")
                .setTitleText(getResources().getString(R.string.app_name))
                .setCustomImage(R.mipmap.ic_launcher)
                .setConfirmText("확인")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        onChangeFragment.onChangeFragment(NoticeListFragment.TAG);
                    }
                }).show();
    }


}
