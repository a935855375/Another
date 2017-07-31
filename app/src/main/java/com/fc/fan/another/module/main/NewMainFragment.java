package com.fc.fan.another.module.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.NewMainAdapter;
import com.fc.fan.another.base.RxLazyFragment;
import com.fc.fan.another.utils.decoration.MainItemDecoration;

import butterknife.BindView;

import static com.fc.fan.another.adpater.NewMainAdapter.BANNER;
import static com.fc.fan.another.adpater.NewMainAdapter.CARD;
import static com.fc.fan.another.adpater.NewMainAdapter.HEADER;

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
                    case CARD:
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
    }
}
