package com.fc.fan.another.module.region;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.RegionItemAdapter;
import com.fc.fan.another.base.RxLazyFragment;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fan on 7/12/17.
 * A nice day..
 */

public class RegionFragment extends RxLazyFragment {
    public final String TAG = RegionFragment.class.getSimpleName();
    RegionItemAdapter mAdapter;

    @BindView(R.id.recycle)
    RecyclerView mRecycleView;

    @BindView(R.id.region_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    public static RegionFragment newInstance() {
        return new RegionFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.region_fragment;
    }

    @Override
    public void finishCreateView(Bundle state) {
        swipeRefreshLayout.setOnRefreshListener(this::refresh);
        initRecycleView();
    }

    private void refresh() {
        load(true);
    }

    private void initRecycleView() {
        mAdapter = new RegionItemAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mAdapter.getItemViewType(position);
                switch (type) {
                    case RegionItemAdapter.VIEW_TYPE_CONTENT:
                        return 1;
                    case RegionItemAdapter.VIEW_TYPE_HEAD:
                        return 3;
                    default:
                        return 1;
                }
            }
        });
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);

        load(false);
    }

    private void load(boolean isClear) {
        if (isClear)
            swipeRefreshLayout.setRefreshing(true);

        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .getRegion()
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    swipeRefreshLayout.setRefreshing(false);
                    mAdapter.setRegionBeans(data);
                    mAdapter.notifyDataSetChanged();
                }, throwable -> {
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(getContext(), "获取分类失败..", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, throwable.getMessage());
                });
    }
}
