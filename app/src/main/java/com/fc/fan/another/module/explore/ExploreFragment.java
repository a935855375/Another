package com.fc.fan.another.module.explore;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.ExploreAdapter;
import com.fc.fan.another.base.RxLazyFragment;
import com.fc.fan.another.utils.decoration.SpacesItemDecoration;

import butterknife.BindView;

/**
 * Created by fan on 7/21/17.
 */

public class ExploreFragment extends RxLazyFragment {
    public static final String TAG = ExploreFragment.class.getSimpleName();

    public static ExploreFragment newInstance() {
        return new ExploreFragment();
    }

    @BindView(R.id.recycle_explore)
    RecyclerView recyclerView;

    private ExploreAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_explore;
    }

    @Override
    public void finishCreateView(Bundle state) {
        initRecycleView();
    }

    private void initRecycleView() {
        adapter = new ExploreAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(25));
    }
}
