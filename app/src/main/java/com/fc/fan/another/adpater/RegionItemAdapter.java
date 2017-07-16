package com.fc.fan.another.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fan on 7/16/17.
 */

public class RegionItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_HEAD = 0;
    public static final int VIEW_TYPE_CONTENT = 1;
    public static final String TAG = RegionItemAdapter.class.getSimpleName();
    private String[] args;
    int i = 0;

    private Context mContext;

    public RegionItemAdapter(String[] args) {
        this.args = args;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        switch (viewType) {
            case VIEW_TYPE_HEAD:
                return new TextViewHolder(LayoutInflater.from(mContext).inflate(R.layout.region_item_text, parent, false));
            case VIEW_TYPE_CONTENT:
                return new ContentViewHolder(LayoutInflater.from(mContext).inflate(R.layout.region_item_content, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            ((TextViewHolder) holder).bind("前端开发");
        } else {
            ((ContentViewHolder) holder).bind(args[position - 1], R.drawable.logo);
        }
    }

    @Override
    public int getItemCount() {
        return args.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        i++;
        switch (position) {
            case 0:
                Log.e(TAG, "haha" + i);
                return VIEW_TYPE_HEAD;
            default:
                Log.e(TAG, "gg" + i);
                return VIEW_TYPE_CONTENT;
        }
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.region_item_label)
        TextView textView;

        TextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(String text) {
            textView.setText(text);
        }
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.region_item_text)
        TextView textView;

        @BindView(R.id.region_item_image)
        CircleImageView circleImageView;

        ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(String text, int id) {
            textView.setText(text);
            Glide.with(mContext).load(id).into(circleImageView);
        }
    }


}
