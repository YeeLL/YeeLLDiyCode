package yeell.yeelldiycode.home.Impl;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import yeell.yeelldiycode.R;
import yeell.yeelldiycode.adapter.HomeFragmentPagerAdapter;
import yeell.yeelldiycode.base.BaseActivity;
import yeell.yeelldiycode.home.injector.DaggerHomeComponent;
import yeell.yeelldiycode.home.injector.HomeComponent;
import yeell.yeelldiycode.home.injector.HomeModule;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.main_tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.main_app_bar)
    AppBarLayout mAppBar;
    @BindView(R.id.main_navigation)
    NavigationView mNavigationView;
    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.main_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    ImageView mHeader;
    TextView mEmail;
    HomeFragmentPagerAdapter mAdapter;
    HomePresenter homePresenter;
    int mCurrentPosition = 0;

    @Inject
    HomePresenter mHomePresenter;

    HomeComponent mHomeComonent;

    @Override
    protected int getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mHomeComonent = DaggerHomeComponent.builder().homeModule(new HomeModule(this)).build();
        mHomeComonent.inject(this);
        initData();
        initToolBar();
        initNavigation();
        initTableLayout();
    }

    public HomeComponent getmHomeComonent() {
        return mHomeComonent;
    }

    private void initData() {
        homePresenter = new HomePresenter(this);
    }

    //初始化TableLayout
    private void initTableLayout() {
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("Topic");
        titleList.add("News");
        titleList.add("Sites");

        ArrayList<Fragment> listFragment = new ArrayList<>();
        listFragment.add(new TopicFragment());
        listFragment.add(new NewsFragment());
        listFragment.add(new SitesFragment());

        mAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), titleList, listFragment);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(mCurrentPosition);
    }

    //初始化Navigation
    private void initNavigation() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //设置navigation Item 点击事件
        mNavigationView.setNavigationItemSelectedListener(this);

        //初始化头像
        View headerView = mNavigationView.getHeaderView(0);
        initHeaderView(headerView);
    }

    //初始化头像
    private void initHeaderView(View headerView) {
        if (headerView == null) {
            return;
        }
        mHeader = (ImageView) headerView.findViewById(R.id.main_navigation_header);
        mEmail = (TextView) headerView.findViewById(R.id.main_navigation_txt_email);
    }

    //初始化ToolBar
    private void initToolBar() {
        setSupportActionBar(mToolbar);
        Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
                        break;
                    case R.id.action_message:
                        break;
                }
                return true;
            }
        };
        mToolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    /**
     * 创建Toolbar menu
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //搜索查询
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my_posts:
                break;
            case R.id.my_collection:
                break;
            case R.id.my_comment:
                break;
            case R.id.my_share:
                break;
            case R.id.about_me:
                break;
            case R.id.settings:
                break;
        }
        mDrawerLayout.closeDrawers();
        return true;
    }
}
