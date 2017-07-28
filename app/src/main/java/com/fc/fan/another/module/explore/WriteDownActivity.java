package com.fc.fan.another.module.explore;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;

import butterknife.BindView;

/**
 * Created by fan on 7/24/17.
 */

public class WriteDownActivity extends RxBaseActivity {

    @BindView(R.id.write_down_toolbar)
    Toolbar toolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_write_down;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("测试");
        }
    }

    private void postData() {
        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
