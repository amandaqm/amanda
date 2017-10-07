package kr.co.niceinfo.qm.amanda.presenter.impl;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.niceinfo.qm.amanda.data.DataManager;
import kr.co.niceinfo.qm.amanda.data.db.model.Crisis;
import kr.co.niceinfo.qm.amanda.data.db.model.Level;
import kr.co.niceinfo.qm.amanda.presenter.CrisisStageMVP;
import kr.co.niceinfo.qm.amanda.presenter.base.BasePresenter;
import kr.co.niceinfo.qm.amanda.utils.rx.SchedulerProvider;
import timber.log.Timber;


public final class CrisisStagePresenter extends BasePresenter<CrisisStageMVP.View> implements CrisisStageMVP.Presenter {


    @Inject
    public CrisisStagePresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }



    public void show() {
        Disposable d1 = getDataManager().getCrisis(Crisis.SERVICES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).filter(item-> item != null && item.size() > 0).subscribe(item-> {
            Timber.d(item.toString());
            Crisis c = item.get(item.size() - 1);
            Disposable d = getDataManager().getCrisisLevels(Crisis.SERVICES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(level -> {
                String desc = "";
                for(Level l : level) {
                    if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    }
                    else if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    }
                    else if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    }
                    else if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    }
                    else if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    }
                }
                getAmandaView().service(c.getLevel(),c.getDate(),desc);
            });
            getCompositeDisposable().add(d);
        });

        Disposable d2 = getDataManager().getCrisis(Crisis.SECURITY).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).filter(item-> item != null && item.size() > 0).subscribe(item-> {
            Crisis c = item.get(item.size() - 1);
            Disposable d = getDataManager().getCrisisLevels(Crisis.SECURITY).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(level -> {
                String desc = "";
                for (Level l : level) {
                    if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    } else if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    } else if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    } else if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    } else if (l.getName().equals(c.getLevel())) {
                        desc = l.getDesc();
                        break;
                    }
                }
                getAmandaView().security(c.getLevel(), c.getDate(), desc);
            });
            getCompositeDisposable().add(d);
        });

        getCompositeDisposable().add(d1);
        getCompositeDisposable().add(d2);
    }

}
