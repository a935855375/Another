package com.fc.fan.another.module.explore;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CommentAdapter;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;
import com.fc.fan.another.utils.decoration.CommentItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fan on 7/25/17.
 * A nice day..
 */

public class CommentActivity extends RxBaseActivity {
    public static final String TAG = CommentActivity.class.getSimpleName();

    @BindView(R.id.comment_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.comment_send)
    ImageView send;

    @BindView(R.id.comment_edit)
    EditText editText;

    @BindView(R.id.comment_toolbar)
    Toolbar toolbar;

    @BindView(R.id.comment_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    CommentAdapter adapter;

    private boolean isEnd;
    private int page = 1;
    private int qid;
    private List<PostCommentBean.ListBean> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        qid = getIntent().getIntExtra("qid", 0);
        list = new ArrayList<>();

        initRecyclerView();
    }


    @Override
    public void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CommentItemDecoration(this));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToFooter = false;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
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

        swipeRefreshLayout.setOnRefreshListener(this::refreshData);
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.close_x);
            actionBar.setTitle("评论");
        }

        getMoreData(false);
    }

    public void requestData(int page, int type, final boolean isClear) {
        if (isClear)
            swipeRefreshLayout.setRefreshing(true);

        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .getPostComment(page, type)
                .doOnNext(x -> {
                    if (x.getList().size() == 0 && list.size() == 0)
                        Toast.makeText(this, "该问题暂时无人评论", Toast.LENGTH_SHORT).show();
                    if (x.getList().size() < x.getLimit())
                        isEnd = true;
                })
                .map(PostCommentBean::getList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
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
            requestData(page, qid, isClear);
            page++;
        } else {
            Toast.makeText(this, "已经滑到底啦", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateData() {
        if (adapter == null) {
            adapter = new CommentAdapter(list);
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
}
