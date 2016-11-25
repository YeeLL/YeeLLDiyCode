package yeell.yeelldiycode.injectors.home;

import android.content.Context;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import yeell.yeelldiycode.adapter.home.TopicAdapter;
import yeell.yeelldiycode.models.home.TopicModel;

/**
 * Created by yee on 11/23/16.
 */
@Module
public class FragmentModule {

    private List<TopicModel> mList;
    private Context mContext;

    public <T> FragmentModule(T t, Context context) {
        mList = (List<TopicModel>) t;
        mContext = context;
    }

    @Provides
    TopicAdapter getTopicAdapter() {
        return new TopicAdapter(mList, mContext);
    }
}
