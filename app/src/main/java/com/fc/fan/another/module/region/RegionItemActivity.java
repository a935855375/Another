package com.fc.fan.another.module.region;

import android.content.Intent;
import android.graphics.Region;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CourseItemAdapter;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.CustomItemDecoration;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fan on 7/22/17.
 */

public class RegionItemActivity extends RxBaseActivity {
    public static final String TAG = RegionItemActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private String title;

    private int tid;

    private int page = 0;

    private boolean isEnd;

    CourseItemAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_region_item;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        tid = intent.getIntExtra("tid", 0);
        adapter = new CourseItemAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new CustomItemDecoration(this));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToFooter = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = linearLayoutManager.getItemCount();
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToFooter) {
                        if (isEnd)
                            Toast.makeText(getBaseContext(), "已经加载到底了", Toast.LENGTH_SHORT).show();
                        else
                            loadMore();
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                isSlidingToFooter = dy > 0;
            }
        });
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(title);
        }
        getData();
    }

    private void getData() {
        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .getRegionItem(tid, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::finishLoad, throwable -> {
                });
    }

    private void finishLoad(RegionItemBean regionItemBean) {
        if (regionItemBean.getList().size() < regionItemBean.getLimit())
            isEnd = true;
        adapter.setRegionItemBean(regionItemBean);
        adapter.notifyDataSetChanged();
    }

    private void loadMore() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
