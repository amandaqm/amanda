package kr.co.niceinfo.qm.amanda.presenter.impl;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.Member;
import kr.co.niceinfo.qm.amanda.presenter.SettingMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;


public final class SettingPresenter extends BasePresenter<SettingMVP.View> implements SettingMVP.Presenter {

    private static final String TAG = "SettingPresenter";



    @Inject
    public SettingPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    public void loadMember(String uid) {
        Disposable d = getDataManager().getMember(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item-> {
                    getAmandaView().loadSuccess(item);
                },err-> {
                    getAmandaView().loadFailed();
                });
        getCompositeDisposable().add(d);


    }



    @Override
    public void update(Member member){
        //validate email and password
        if (member.getDepartment() == null || member.getDepartment().isEmpty()) {
            getAmandaView().onError(R.string.empty_department);
            return;
        }
        //validate email and password
        if (member.getName() == null || member.getName().isEmpty()) {
            getAmandaView().onError(R.string.empty_name);
            return;
        }

        //validate email and password
        if (member.getTel() == null || member.getTel().isEmpty()) {
            getAmandaView().onError(R.string.empty_tel);
            return;
        }
        //validate email and password
        if (member.getEtel() == null || member.getEtel().isEmpty()) {
            getAmandaView().onError(R.string.empty_etel);
            return;
        }


        getAmandaView().showLoading();

        Disposable d = getDataManager().updateUserInDatabase(member)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item-> {
                    getAmandaView().updateSuccess();
                },err-> {
                    getAmandaView().updateFailed();
                });


        getCompositeDisposable().add(d);


    }




}
