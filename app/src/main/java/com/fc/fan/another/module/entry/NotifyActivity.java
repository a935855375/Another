package com.fc.fan.another.module.entry;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.NotifyAdapter;
import com.fc.fan.another.base.RxBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by fan on 8/2/17.
 * A nice day..
 */

public class NotifyActivity extends RxBaseActivity {
    public static final String TAG = NotifyActivity.class.getSimpleName();

    @BindView(R.id.notify_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.notify_no_notify)
    TextView no_notify;

    @BindView(R.id.notify_toolbar)
    Toolbar toolbar;

    NotifyAdapter adapter;

    List<NotifyBean> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_notify;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        list = new ArrayList<>();
        adapter = new NotifyAdapter(list);
        recyclerView.setAdapter(adapter);
        if (list.size() == 0)
            recyclerView.setVisibility(View.GONE);
        else
            no_notify.setVisibility(View.GONE);
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("通知");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
