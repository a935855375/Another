package com.fc.fan.another.module.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.NewMainAdapter;
import com.fc.fan.another.base.RxLazyFragment;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;
import com.fc.fan.another.utils.decoration.MainItemDecoration;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.fc.fan.another.adpater.NewMainAdapter.BANNER;
import static com.fc.fan.another.adpater.NewMainAdapter.COURSE_CARD;
import static com.fc.fan.another.adpater.NewMainAdapter.HEADER;
import static com.fc.fan.another.adpater.NewMainAdapter.PLAN_CARD;

/**
 * Created by fan on 7/30/17.
 * A nice day..
 */

public class NewMainFragment extends RxLazyFragment {
    public static final String TAG = NewMainFragment.class.getSimpleName();

    public static NewMainFragment newInstance() {
        return new NewMainFragment();
    }

    @BindView(R.id.main_recyclerView)
    RecyclerView recyclerView;


    private NewMainAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_new_main;
    }

    @Override
    public void finishCreateView(Bundle state) {
        adapter = new NewMainAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = adapter.getItemViewType(position);
                switch (type) {
                    case BANNER:
                        return 2;
                    case HEADER:
                        return 2;
                    case COURSE_CARD:
                        return 1;
                    case PLAN_CARD:
                        return 1;
                    default:
                        return 2;
                }
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MainItemDecoration());
        recyclerView.setAdapter(adapter);

        loadData();
    }

    protected void loadData() {
        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .getMainBean()
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    adapter.setMainBean(data);
                    adapter.notifyDataSetChanged();
                }, throwable -> {
                    Toast.makeText(getContext(), "是不是网络有点问题?", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, throwable.getMessage());
                });
    }
}
