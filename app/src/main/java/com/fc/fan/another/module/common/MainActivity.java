package com.fc.fan.another.module.common;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;

public class MainActivity extends RxBaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.pager)
    ViewPager viewPager;

    @BindView(R.id.tabhost)
    TabLayout tabHost;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;

    FragmentAdapter pagerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        toolbar.setTitle("首页");
        pagerAdapter = new FragmentAdapter(getSupportFragmentManager(), getLayoutInflater());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                toolbar.setTitle(pagerAdapter.getPageTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabHost.setupWithViewPager(viewPager);
        tabHost.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < 4; i++) {
            TabLayout.Tab tab = tabHost.getTabAt(i);
            assert tab != null;
            tab.setCustomView(pagerAdapter.getTypeView(i));
        }

        initSearchView();
    }

    private void initSearchView() {
        //初始化SearchBar
        mSearchView.setVoiceSearch(false);
        mSearchView.setCursorDrawable(R.drawable.custom_cursor);
        mSearchView.setEllipsize(true);
        mSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e(TAG, "good");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        mSearchView.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
