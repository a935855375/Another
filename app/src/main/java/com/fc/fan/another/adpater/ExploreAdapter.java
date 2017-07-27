package com.fc.fan.another.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.module.explore.ExploreActivity;
import com.fc.fan.another.module.explore.ExploreRegionBean;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExploreAdapter extends RecyclerView.Adapter {
    public static final String TAG = ExploreAdapter.class.getSimpleName();
    private Context mContext;
    private List<ExploreRegionBean.ListBean> list;

    public ExploreAdapter(List<ExploreRegionBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.explore_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.explore_item_image)
        ImageView imageView;

        @BindView(R.id.explore_item_text)
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(ExploreRegionBean.ListBean bean) {
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getPicture()).into(imageView);
            textView.setText(bean.getName());
            this.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, ExploreActivity.class);
                intent.putExtra("style", bean.getStyle());
                intent.putExtra("name", bean.getName());
                mContext.startActivity(intent);
            });
        }
    }
}
