package com.fc.fan.another.module.mine;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CollectionItemAdapter;
import com.fc.fan.another.adpater.HistoryItemAdapter;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.decoration.CustomItemDecoration;

import butterknife.BindView;

/**
 * Created by fan on 7/29/17.
 * A nice day..
 */

public class CollectionActivity extends RxBaseActivity {
    public static final String TAG = CollectionActivity.class.getSimpleName();

    @BindView(R.id.collection_toolbar)
    Toolbar toolbar;

    @BindView(R.id.collection_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.collection_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private CollectionItemAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        adapter = new CollectionItemAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new CustomItemDecoration(this));
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("我的收藏");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
