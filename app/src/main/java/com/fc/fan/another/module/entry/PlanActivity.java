package com.fc.fan.another.module.entry;

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
import com.fc.fan.another.adpater.PlanItemAdapter;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;
import com.fc.fan.another.utils.decoration.CustomItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fan on 8/1/17.
 * A nice day..
 */

public class PlanActivity extends RxBaseActivity {
    public static final String TAG = PlanActivity.class.getSimpleName();

    @BindView(R.id.plan_toolbar)
    Toolbar toolbar;

    @BindView(R.id.plan_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.plan_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private PlanItemAdapter adapter;

    private List<PlanBean.CoursesBean> list;

    private int pid;

    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_plan;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        pid = getIntent().getIntExtra("pid", 0);
        title = getIntent().getStringExtra("title");

        list = new ArrayList<>();
        adapter = new PlanItemAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new CustomItemDecoration(this));

        swipeRefreshLayout.setOnRefreshListener(this::refreshData);
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(title);
        }

        Log.e(TAG, pid + "");
        requestData(pid, false);
    }

    private void requestData(int pid, final boolean isClear) {
        if (isClear)
            swipeRefreshLayout.setRefreshing(true);

        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .getDirectionCourse(pid)
                .compose(bindToLifecycle())
                .map(x -> x.get(0))
                .map(PlanBean::getCourses)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    if (data.size() == 0)
                        Toast.makeText(this, "该计划还没有任何视频", Toast.LENGTH_SHORT).show();

                    if (isClear)
                        list.clear();

                    list.addAll(data);

                    swipeRefreshLayout.setRefreshing(false);

                    updateData();
                }, throwable -> {
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(this, "是不是网络出现了问题", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, throwable.getMessage());
                });
    }

    private void refreshData() {
        requestData(pid, true);
    }

    private void updateData() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
