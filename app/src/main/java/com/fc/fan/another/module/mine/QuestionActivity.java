package com.fc.fan.another.module.mine;

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
import com.fc.fan.another.adpater.QuestionAdapter;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.module.common.bean.LoginStatusBean;
import com.fc.fan.another.module.explore.ExplorePostBean;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fan on 7/30/17.
 * A nice day..
 */

public class QuestionActivity extends RxBaseActivity {
    public static final String TAG = QuestionActivity.class.getSimpleName();

    @BindView(R.id.question_toolbar)
    Toolbar toolbar;

    @BindView(R.id.question_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.question_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;


    private QuestionAdapter adapter;

    private boolean isEnd;

    private int page = 1;

    private int uid;

    private List<ExplorePostBean.ListBean> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_question;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Gson gson = new Gson();
        LoginStatusBean.UserBean bean = gson.fromJson(PreferenceUtil
                .getString("user", null), LoginStatusBean.UserBean.class);
        uid = bean.getUid();
        list = new ArrayList<>();
        adapter = new QuestionAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this::refreshData);
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("我的提问");
        }

        Log.e(TAG, "uid = " + uid + ",page = " + page);
        getMoreData(false);
    }

    private void requestData(int page, int uid, final boolean isClear) {
        if (isClear)
            swipeRefreshLayout.setRefreshing(true);

        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .getQuestion(page, uid)
                .compose(bindToLifecycle())
                .doOnNext(data -> {
                    if (data.getList().size() < data.getLimit())
                        isEnd = true;
                })
                .map(ExplorePostBean::getList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    if (data.size() == 0 && list.size() == 0)
                        Toast.makeText(this, "你还未起任何提问", Toast.LENGTH_SHORT).show();

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
        page = 1;
        isEnd = false;
        getMoreData(true);
    }

    private void updateData() {
        adapter.notifyDataSetChanged();
    }

    private void getMoreData(boolean isClear) {
        if (!isEnd) {
            requestData(page, uid, isClear);
            page++;
        } else {
            Toast.makeText(this, "已经滑到底啦", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
