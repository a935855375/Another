package com.fc.fan.another.module.course;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CourseChapterAdapter;
import com.fc.fan.another.base.RxLazyFragment;
import com.fc.fan.another.utils.decoration.SpacesItemVerticalDecoration;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fan on 7/25/17.
 * A nice day..
 */

public class ChapterFragment extends RxLazyFragment {
    public static final String TAG = ChapterFragment.class.getSimpleName();

    private CourseChapterAdapter adapter;

    public static ChapterFragment newInstance() {
        return new ChapterFragment();
    }

    @BindView(R.id.chapter_recycler)
    RecyclerView recyclerView;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_chapter;
    }

    @Override
    public void finishCreateView(Bundle state) {
        initRecyclerView();
    }

    protected void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new SpacesItemVerticalDecoration(50));
        //recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
    }

    public void setResource(List<ResourceBean.ResourceListBean> videoList) {
        adapter = new CourseChapterAdapter(videoList, getActivity());
        recyclerView.setAdapter(adapter);
    }
}
