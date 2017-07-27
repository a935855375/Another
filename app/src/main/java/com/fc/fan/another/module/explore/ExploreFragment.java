package com.fc.fan.another.module.explore;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.ExploreAdapter;
import com.fc.fan.another.base.RxLazyFragment;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;
import com.fc.fan.another.utils.decoration.SpacesItemDecoration;

import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ExploreFragment extends RxLazyFragment {
    public static final String TAG = ExploreFragment.class.getSimpleName();

    public static ExploreFragment newInstance() {
        return new ExploreFragment();
    }

    @BindView(R.id.recycle_explore)
    RecyclerView recyclerView;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_explore;
    }

    @Override
    public void finishCreateView(Bundle state) {
        initRecycleView();
        getData();
    }

    private void initRecycleView() {
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(25));
    }

    private void getData() {
        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .getExploreRegion()
                .map(ExploreRegionBean::getList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::finishLoad, throwable ->
                        Toast.makeText(getContext(), "获取论坛分区失败", Toast.LENGTH_SHORT).show());
    }

    private void finishLoad(List<ExploreRegionBean.ListBean> list) {
        if (list.size() == 0) {
            Toast.makeText(getContext(), "目前没有板块", Toast.LENGTH_SHORT).show();
            return;
        }
        ExploreAdapter adapter = new ExploreAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
