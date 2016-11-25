package yeell.yeelldiycode.injectors.home;

import dagger.Component;
import yeell.yeelldiycode.base.PerActivity;
import yeell.yeelldiycode.views.home.Impl.HomeActivity;

/**
 * Created by yee on 11/23/16.
 */
@PerActivity
@Component(modules = HomeModule.class)
public interface HomeComponent {

    FragmentComponent getFragmentComponent(FragmentModule fragmentModule);

    void inject(HomeActivity homeActivity);
}
