package kr.co.niceinfo.qm.amanda.ui.notice.reg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.di.component.ActivityComponent;
import kr.co.niceinfo.qm.amanda.ui.base.BaseFragment;
import kr.co.niceinfo.qm.amanda.ui.notice.list.NoticeListActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class NoticeRegActivityFragment extends BaseFragment implements NoticeRegMvpView{

    private static final String TAG = "NoticeRegActivityFragment";

    @Inject
    NoticeRegMvpPresenter<NoticeRegMvpView> mPresenter;

    @BindView(R.id.et_notice_title)
    EditText etNoticeTitle;

    @BindView(R.id.et_notice_content)
    EditText etNoticeContent;

    @BindView(R.id.bt_notice_reg)
    Button btNoticeReg;


    public NoticeRegActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_reg, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        return view;
    }



    @OnClick(R.id.bt_notice_reg)
    void onNoticeRegClick(View v) {

        Board notice = new Board();
        notice.setPostingTitle(etNoticeTitle.getText().toString());
        notice.setPostingContent(etNoticeContent.getText().toString());
        notice.setVer(1);

        mPresenter.regNotice(notice);

    }



    @Override
    protected void setUp(View view) {

    }

    @Override
    public ActivityComponent getActivityComponent() {
        return super.getActivityComponent();
    }

    @Override
    public void openNoticeListActivity() {
        Intent intent = new Intent(getActivity(), NoticeListActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}
