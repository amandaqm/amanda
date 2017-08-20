package kr.co.niceinfo.qm.amanda.di.component;


import dagger.Component;
import kr.co.niceinfo.qm.amanda.di.PerActivity;
import kr.co.niceinfo.qm.amanda.di.module.ActivityModule;
import kr.co.niceinfo.qm.amanda.ui.main.MainActivity;

/**
 * Created by janisharali on 27/01/17.
 */


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
