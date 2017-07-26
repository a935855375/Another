package com.fc.fan.another.module.course;

import android.os.Bundle;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxLazyFragment;

import butterknife.BindView;

/**
 * Created by fan on 7/25/17.
 * A nice day..
 */

public class DetailFragment extends RxLazyFragment {
    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @BindView(R.id.course_describe)
    TextView describe;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_course_detail;
    }

    @Override
    public void finishCreateView(Bundle state) {

    }

    public void setCotent(String content) {
        describe.setText(content);
    }


}
