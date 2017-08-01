package com.fc.fan.another.module.explore;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

    @BindView(R.id.cancel_reply)
    TextView cancel_reply;

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

        cancel_reply.setVisibility(View.GONE);

        cancel_reply.setOnClickListener(view -> {
            editText.setHint("添加评论");
            cancel_reply.setVisibility(View.GONE);
        });

        initRecyclerView();

        swipeRefreshLayout.setOnRefreshListener(this::refreshData);


        send.setOnClickListener(view -> {
            if (valid()) {
                String hint = editText.getHint().toString();
                if (hint.startsWith("添加评论")) {
                    String content = editText.getText().toString();
                    postData(content, 1, qid);
                } else {
                    String content = hint + editText.getText().toString();
                    postData(content, 1, qid);
                }
            }
        });
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
    }

    private void postData(String content, int uid, int qid) {
        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .postWriteCommentDown(content, uid, qid)
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(x -> {
                    if (x.getMsg() == 1) {
                        editText.clearFocus();
                        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        editText.setText("");
                        if (editText.getHint().toString().startsWith("回复")) {
                            editText.setHint("添加评论");
                            Snackbar.make(editText, "回复成功", Snackbar.LENGTH_SHORT)
                                    .setAction("查看", view -> {

                                    }).show();
                            cancel_reply.setVisibility(View.GONE);
                        } else {
                            Snackbar.make(editText, "评论成功", Snackbar.LENGTH_SHORT)
                                    .setAction("查看", view -> {

                                    }).show();
                        }
                        refreshData();
                    } else
                        Snackbar.make(editText, "评论失败", Snackbar.LENGTH_SHORT)
                                .show();
                }, throwable -> {
                    Toast.makeText(this, "网络错误", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, throwable.getMessage());
                });
    }

    private boolean valid() {
        boolean flag = true;
        String content = editText.getText().toString();
        if (content.isEmpty()) {
            flag = false;
            Toast.makeText(this, "评论不能为空", Toast.LENGTH_SHORT).show();
        }
        return flag;
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
                .compose(bindToLifecycle())
                .doOnNext(x -> {
                    if (x.getList().size() < x.getLimit())
                        isEnd = true;
                })
                .map(PostCommentBean::getList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    if (data.size() == 0 && list.size() == 0)
                        Toast.makeText(this, "该问题暂时无人评论", Toast.LENGTH_SHORT).show();

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

    public EditText getEditText() {
        return editText;
    }

    public TextView getCancelButton() {
        return cancel_reply;
    }
}
