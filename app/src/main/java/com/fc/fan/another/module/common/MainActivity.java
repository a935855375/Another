package com.fc.fan.another.module.common;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;

import butterknife.BindView;

public class MainActivity extends RxBaseActivity {

    @BindView(R.id.pager)
    ViewPager viewPager;

    @BindView(R.id.tabhost)
    TabLayout tabHost;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    FragmentAdapter pagerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        pagerAdapter = new FragmentAdapter(getSupportFragmentManager(), getLayoutInflater());
        viewPager.setAdapter(pagerAdapter);
        tabHost.setupWithViewPager(viewPager);
        tabHost.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < 4; i++) {
            TabLayout.Tab tab = tabHost.getTabAt(i);
            assert tab != null;
            tab.setCustomView(pagerAdapter.getTypeView(i));
        }
    }

    @Override
    public void initToolBar() {
        toolbar.setTitle("首页");
    }
}
