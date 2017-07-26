package com.fc.fan.another.module.explore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.ExploreItemAdapter;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.decoration.SpacesItemVerticalDecoration;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import butterknife.BindView;


public class ExploreActivity extends RxBaseActivity {
    public static final String TAG = ExploreActivity.class.getSimpleName();
    private String region;

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

    ExploreItemAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_explore;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        adapter = new ExploreItemAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new SpacesItemVerticalDecoration(20));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 3)
                    fab.hideMenuButton(true);
                else if (dy < -3)
                    fab.showMenuButton(true);
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        fab.setClosedOnTouchOutside(true);

        recyclerView.setAdapter(adapter);

        makePost.setOnClickListener(view -> {
            Intent intent = new Intent(this, WriteDownActivity.class);
            startActivity(intent);
            fab.close(true);
        });

        test.setOnClickListener(view -> {
            Intent intent = new Intent(this, CommentActivity.class);
            startActivity(intent);
            fab.close(true);
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
