package com.fc.fan.another.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fc.fan.another.R;

/**
 * Created by fan on 7/30/17.
 * A nice day..
 */

public class CollectionItemAdapter extends RecyclerView.Adapter {
    public static final String TAG = CollectionItemAdapter.class.getSimpleName();
    private Context mContext;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.collection_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
