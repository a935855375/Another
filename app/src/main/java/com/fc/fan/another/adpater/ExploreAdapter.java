package com.fc.fan.another.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.module.explore.ExploreActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan on 7/23/17.
 */

public class ExploreAdapter extends RecyclerView.Adapter {
    public static final String TAG = ExploreAdapter.class.getSimpleName();
    private Context mContext;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.explore_item, parent, false);
        view.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, ExploreActivity.class);
            mContext.startActivity(intent);
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind();
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.explore_item_image)
        ImageView imageView;

        @BindView(R.id.explore_item_text)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind() {
            imageView.setImageResource(R.drawable.logo);
            textView.setText("测试");
        }
    }
}
