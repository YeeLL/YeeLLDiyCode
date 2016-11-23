package yeell.yeelldiycode.home.injector;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import yeell.yeelldiycode.base.PerActivity;
import yeell.yeelldiycode.home.Impl.HomeActivity;
import yeell.yeelldiycode.home.Impl.HomePresenter;

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
