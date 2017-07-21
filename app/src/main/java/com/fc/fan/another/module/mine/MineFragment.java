package com.fc.fan.another.module.mine;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxLazyFragment;

import butterknife.BindView;

/**
 * Created by fan on 7/17/17.
 */

public class MineFragment extends RxLazyFragment {
    public static final String TAG = MineFragment.class.getSimpleName();

    @BindView(R.id.my_history)
    LinearLayout myHistory;

    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    public int getLayoutResId() {
        return R.layout.mine_fragment;
    }

    @Override
    public void finishCreateView(Bundle state) {
        myHistory.setOnClickListener(view -> Log.e(TAG, "Test"));
    }
}
