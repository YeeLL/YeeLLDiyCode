package yeell.yeelldiycode.home.Impl;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import yeell.yeelldiycode.R;
import yeell.yeelldiycode.base.BaseFragment;
import yeell.yeelldiycode.home.IHomePresenter;
import yeell.yeelldiycode.home.IHomeView;
import yeell.yeelldiycode.home.injector.DaggerHomeComponent;
import yeell.yeelldiycode.home.injector.FragmentModule;

/**
 * Created by yee on 11/22/16.
 */

public class TopicFragment extends BaseFragment implements IHomeView {

    @Inject
    HomePresenter mHomePresenter;
    private int mBeginIndex = 0;

    @Override
    protected int getContentId() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        ((HomeActivity) getActivity()).getmHomeComonent()
                .getFragmentComPonet(new FragmentModule()).inject(this);
        initView();
    }

    private void initView() {
        mHomePresenter.getTopicData(mBeginIndex, this);
    }

    @Override
    public <T> void loadData(List<T> topicModel) {
        List<TopicModel> list = (List<TopicModel>) topicModel;
        Log.e("eeeeee", list.get(0).title.toString());
    }
}
