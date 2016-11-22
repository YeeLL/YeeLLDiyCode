package yeell.yeelldiycode.views.main.impl;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import yeell.yeelldiycode.R;
import yeell.yeelldiycode.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.main_tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.main_app_bar)
    AppBarLayout mAppBar;
    @BindView(R.id.main_navigation)
    NavigationView mNavigationView;
    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;

    ImageView mHeader;
    TextView mEmail;

    @Override
    protected int getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setToolBar();
        setNavigation();
    }

    private void setNavigation() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
        });

        //初始化头像
        View headerView = mNavigationView.getHeaderView(0);
        initHeaderView(headerView);
    }

    private void initHeaderView(View headerView) {
        if (headerView == null) {
            return;
        }
        mHeader = (ImageView) headerView.findViewById(R.id.main_navigation_header);
        mEmail = (TextView) headerView.findViewById(R.id.main_navigation_txt_email);
    }


    private void setToolBar() {
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
}
