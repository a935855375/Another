package com.fc.fan.another.module.explore;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CommentAdapter;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.decoration.CommentItemDecoration;

import butterknife.BindView;

/**
 * Created by fan on 7/25/17.
 * A nice day..
 */

public class CommentActivity extends RxBaseActivity {

    @BindView(R.id.comment_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.comment_send)
    ImageView send;

    @BindView(R.id.comment_edit)
    EditText editText;

    @BindView(R.id.comment_toolbar)
    Toolbar toolbar;

    CommentAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initRecyclerView();
    }


    @Override
    public void initRecyclerView() {
        adapter = new CommentAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CommentItemDecoration(this));
        recyclerView.setAdapter(adapter);
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

    public EditText getEdit() {
        return editText;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
