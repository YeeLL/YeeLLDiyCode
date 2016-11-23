package yeell.yeelldiycode.home.injector;

import dagger.Component;
import dagger.Subcomponent;
import yeell.yeelldiycode.base.PerFragment;
import yeell.yeelldiycode.home.Impl.TopicFragment;

/**
 * Created by yee on 11/23/16.
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(TopicFragment topicFragment);
}
