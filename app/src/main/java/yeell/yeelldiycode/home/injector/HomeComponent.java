package yeell.yeelldiycode.home.injector;

import javax.inject.Singleton;

import dagger.Component;
import yeell.yeelldiycode.base.PerActivity;
import yeell.yeelldiycode.home.Impl.HomeActivity;

/**
 * Created by yee on 11/23/16.
 */
@PerActivity
@Component(modules = HomeModule.class)
public interface HomeComponent {

    FragmentComponent getFragmentComPonet(FragmentModule fragmentModule);

    void inject(HomeActivity homeActivity);
}
