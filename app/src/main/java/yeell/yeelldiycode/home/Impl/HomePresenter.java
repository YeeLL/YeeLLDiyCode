package yeell.yeelldiycode.home.Impl;

import android.app.Activity;

import java.util.List;

import rx.functions.Action1;
import rx.schedulers.Schedulers;
import yeell.yeelldiycode.rxUtils.apiutils.ApiManagers;


/**
 * Created by yee on 11/22/16.
 */

public class HomePresenter {

    HomeActivity homeActivity;

    public HomePresenter(Activity activity) {
        this.homeActivity = (HomeActivity) activity;
    }

    /**
     * 获取Topic数据
     *
     * @param mBeginIndex
     * @param topicFragment
     */
    public void getTopicData(int mBeginIndex, final TopicFragment topicFragment) {
        ApiManagers.getApiService().getTopicList().subscribeOn(Schedulers.newThread()).subscribe(new Action1<List<TopicModel>>() {
            @Override
            public void call(List<TopicModel> topicModels) {
                topicFragment.loadData(topicModels);
            }
        });
    }
}
