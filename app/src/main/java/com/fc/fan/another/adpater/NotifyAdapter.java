package com.fc.fan.another.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.fc.fan.another.module.entry.NotifyBean;

import java.util.List;

/**
 * Created by fan on 8/2/17.
 * A nice day..
 */

public class NotifyAdapter extends RecyclerView.Adapter {
    public static final String TAG = NotifyAdapter.class.getSimpleName();

    List<NotifyBean> list;

    public NotifyAdapter(List<NotifyBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
