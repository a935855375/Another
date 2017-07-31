package com.fc.fan.another.module.course;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CourseDetailAdapter;
import com.fc.fan.another.base.RxLazyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by fan on 7/25/17.
 * A nice day..
 */

public class DetailFragment extends RxLazyFragment {
    public static final String TAG = DetailFragment.class.getSimpleName();

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }


    @BindView(R.id.course_describe)
    TextView describe;

    @BindView(R.id.course_count)
    TextView count;

    @BindView(R.id.course_recycler)
    RecyclerView recyclerView;

    private List<ResourceBean.OfficListBean> list;

    private CourseDetailAdapter adapter;

    public void setResource(List<ResourceBean.OfficListBean> officeList) {
        this.list.addAll(officeList);
        if (officeList.size() != 0)
            count.setText("该课程有" + officeList.size() + "个课件");
        adapter.notifyDataSetChanged();
    }


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_course_detail;
    }

    @Override
    public void finishCreateView(Bundle state) {
        list = new ArrayList<>();
        adapter = new CourseDetailAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void setContent(String content) {
        describe.setText(content);
    }


}
