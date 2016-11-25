package yeell.yeelldiycode.views.home.Impl;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import yeell.yeelldiycode.R;
import yeell.yeelldiycode.adapter.home.TopicAdapter;
import yeell.yeelldiycode.base.BaseFragment;
import yeell.yeelldiycode.injectors.home.FragmentModule;
import yeell.yeelldiycode.models.home.TopicModel;
import yeell.yeelldiycode.presenters.home.Impl.HomePresenter;
import yeell.yeelldiycode.views.home.IHomeView;

/**
 * Created by yee on 11/22/16.
 */

public class TopicFragment extends BaseFragment implements IHomeView {

    @BindView(R.id.topic_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.topic_refresh)
    SwipeRefreshLayout mRefresh;

    @Inject
    HomePresenter mHomePresenter;
    @Inject
    TopicAdapter mAdapter;

    private int mOffSet = 0;
    private List<TopicModel> mList = new ArrayList<>();

    @Override
    protected int getContentId() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        ((HomeActivity) getActivity()).getmHomeComonent()
                .getFragmentComponent(new FragmentModule(mList, getContext())).inject(this);
        initRecyclerView();
        loadData();

    }

    private void initRecyclerView() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefresh.setRefreshing(true);
                mOffSet = 0;
                loadData();
            }
        });
    }

    private void loadData() {
        mHomePresenter.getTopicData(mOffSet, this);
    }

    @Override
    public <T> void setupData(List<T> topicModel) {
        mRefresh.setRefreshing(false);
        if (mOffSet == 0) {
            mList.clear();
        }
        mOffSet += 1;
        List<TopicModel> modelList = (List<TopicModel>) topicModel;
        mList.addAll(modelList);
        if (mList != null && mList.size() != 0) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
