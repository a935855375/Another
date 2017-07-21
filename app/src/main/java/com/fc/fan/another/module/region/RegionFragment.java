package com.fc.fan.another.module.region;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.RegionItemAdapter;
import com.fc.fan.another.base.RxLazyFragment;

import butterknife.BindView;

/**
 * Created by fan on 7/12/17.
 */

public class RegionFragment extends RxLazyFragment {
    public final String TAG = RegionFragment.class.getSimpleName();

    @BindView(R.id.recycle)
    RecyclerView mRecycleView;

    public static RegionFragment newInstance() {
        return new RegionFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.region_fragment;
    }

    @Override
    public void finishCreateView(Bundle state) {
        initRecycleView();
    }

    private void initRecycleView() {
        RegionItemAdapter mAdapter = new RegionItemAdapter(new String[]{"java",
                "html", "scala", "css", "node.js"});
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
    }

}
