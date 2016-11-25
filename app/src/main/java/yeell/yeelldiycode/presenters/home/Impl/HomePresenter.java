package yeell.yeelldiycode.presenters.home.Impl;

import android.app.Activity;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import yeell.yeelldiycode.models.home.TopicModel;
import yeell.yeelldiycode.rxUtils.apiutils.ApiManagers;
import yeell.yeelldiycode.views.home.Impl.HomeActivity;
import yeell.yeelldiycode.views.home.Impl.TopicFragment;


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
     * @param offset
     * @param topicFragment
     */
    public void getTopicData(int offset, final TopicFragment topicFragment) {
        ApiManagers.getApiService().getTopicList(offset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<List<TopicModel>>() {
                    @Override
                    public void call(List<TopicModel> topicModels) {
                        topicFragment.setupData(topicModels);
                    }
                });
    }
}
