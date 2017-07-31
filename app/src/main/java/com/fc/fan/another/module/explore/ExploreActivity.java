package com.fc.fan.another.module.explore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.ExploreItemAdapter;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;
import com.fc.fan.another.utils.decoration.SpacesItemVerticalDecoration;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ExploreActivity extends RxBaseActivity {
    public static final String TAG = ExploreActivity.class.getSimpleName();

    public static final int WRITEDOWNRETURN = 1;

    @BindView(R.id.recycler_explore)
    RecyclerView recyclerView;

    @BindView(R.id.fab)
    FloatingActionMenu fab;

    @BindView(R.id.explore_toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab_make_post)
    FloatingActionButton makePost;

    @BindView(R.id.fab_test)
    FloatingActionButton test;

    @BindView(R.id.explore_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    ExploreItemAdapter adapter;

    private int style;

    private boolean isEnd;

    private int page = 1;

    private String name;

    @Override
    public int getLayoutId() {
        return R.layout.activity_explore;
    }

    private List<ExplorePostBean.ListBean> list;

    @Override
    public void initViews(Bundle savedInstanceState) {
        style = getIntent().getIntExtra("style", 0);
        name = getIntent().getStringExtra("name");
        list = new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SpacesItemVerticalDecoration(20));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToFooter = false;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 3)
                    fab.hideMenuButton(true);
                else if (dy < -3)
                    fab.showMenuButton(true);

                isSlidingToFooter = dy > 0;
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = linearLayoutManager.getItemCount();
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToFooter) {
                        getMoreData(false);
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        fab.setClosedOnTouchOutside(true);

        makePost.setOnClickListener(view -> {
            Intent intent = new Intent(this, WriteDownActivity.class);
            intent.putExtra("type", style);
            startActivityForResult(intent, 1);
            fab.postDelayed((() -> fab.close(true)), 300);
        });

        test.setOnClickListener(view -> {
            Intent intent = new Intent(this, CommentActivity.class);
            startActivity(intent);
            fab.postDelayed((() -> fab.close(true)), 300);
        });

        swipeRefreshLayout.setOnRefreshListener(this::refreshData);
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(name);
        }
        getMoreData(false);
    }

    public void requestData(int page, int type, final boolean isClear) {

        Log.e(TAG, "type = " + type + ",page = " + page);

        if (isClear) {
            swipeRefreshLayout.setRefreshing(true);
        }

        HttpUtils.getInstance().create(ApiService.class, PreferenceUtil.baseUrl)
                .getExplorePost(page, type)
                .compose(bindToLifecycle())
                .doOnNext(x -> {
                    if (x.getList().size() < x.getLimit())
                        isEnd = true;
                })
                .map(ExplorePostBean::getList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    if (data.size() == 0 && list.size() == 0)
                        Toast.makeText(this, "该板块还没有人发帖", Toast.LENGTH_SHORT).show();

                    if (isClear)
                        list.clear();

                    list.addAll(data);

                    swipeRefreshLayout.setRefreshing(false);
                    updateData();
                }, throwable -> {
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(this, "获取数据出错了", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, throwable.getMessage());
                });
    }

    private void refreshData() {
        page = 1;
        isEnd = false;
        getMoreData(true);
    }

    private void getMoreData(boolean isClear) {
        if (!isEnd) {
            requestData(page, style, isClear);
            page++;
        } else {
            Toast.makeText(this, "已经滑到底啦", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateData() {
        if (adapter == null) {
            adapter = new ExploreItemAdapter(list);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case WRITEDOWNRETURN:
                if (resultCode == RESULT_OK)
                    refreshData();
                break;
        }
    }
}
