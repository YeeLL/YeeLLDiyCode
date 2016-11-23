package yeell.yeelldiycode.home.Impl;

import android.os.Bundle;

import yeell.yeelldiycode.R;
import yeell.yeelldiycode.base.BaseFragment;

/**
 * Created by yee on 11/22/16.
 */

public class NewsFragment extends BaseFragment {


    @Override
    protected int getContentId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        loadData();

    }

    /**
     * 加载数据
     */
    private void loadData() {

    }
}
