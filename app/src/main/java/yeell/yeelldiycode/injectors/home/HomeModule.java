package yeell.yeelldiycode.injectors.home;

import dagger.Module;
import dagger.Provides;
import yeell.yeelldiycode.base.PerActivity;
import yeell.yeelldiycode.presenters.home.Impl.HomePresenter;
import yeell.yeelldiycode.views.home.Impl.HomeActivity;

/**
 * Created by yee on 11/23/16.
 */
@Module
public class HomeModule {

    private HomeActivity mHomeActivity;

    public HomeModule(HomeActivity homeActivity) {
        this.mHomeActivity = homeActivity;
    }

    @PerActivity
    @Provides
    HomePresenter getHomePresenter() {
        return new HomePresenter(mHomeActivity);
    }
}
