package yeell.yeelldiycode.presenters.main.impl;

import android.app.Activity;

import yeell.yeelldiycode.views.main.IHomeView;
import yeell.yeelldiycode.views.main.impl.HomeActivity;

/**
 * Created by yee on 11/22/16.
 */

public class HomePresenter {

    HomeActivity homeActivity;

    public HomePresenter(Activity activity) {
        this.homeActivity = (HomeActivity) activity;
    }

    public void getFragmentPage(){}

}
