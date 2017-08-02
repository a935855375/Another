package com.fc.fan.another.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.module.region.RegionBean;
import com.fc.fan.another.module.region.RegionItemActivity;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class RegionItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_HEAD = 0;
    public static final int VIEW_TYPE_CONTENT = 1;
    public static final String TAG = RegionItemAdapter.class.getSimpleName();
    private HashMap<Integer, RegionBean> titleMap;
    private HashMap<Integer, RegionBean.TypesBean> typeMap;

    private Context mContext;

    public RegionItemAdapter() {
        titleMap = new HashMap<>();
        typeMap = new HashMap<>();
    }

    public void setRegionBeans(List<RegionBean> regionBeanList) {
        int q = 0;
        for (RegionBean regionBean : regionBeanList) {
            titleMap.put(q, regionBean);
            q++;
            for (RegionBean.TypesBean typeBean : regionBean.getTypes()) {
                typeMap.put(q, typeBean);
                q++;
            }
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        switch (viewType) {
            case VIEW_TYPE_HEAD:
                return new TextViewHolder(LayoutInflater.from(mContext).inflate(R.layout.region_item_text, parent, false));
            case VIEW_TYPE_CONTENT:
                RecyclerView.ViewHolder holder = new ContentViewHolder(LayoutInflater.from(mContext).inflate(R.layout.region_item_content, parent, false));
                holder.itemView.setOnClickListener(view -> {
                    Toast.makeText(mContext, "position:" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(parent.getContext(), RegionItemActivity.class);
                    RegionBean.TypesBean bean = typeMap.get(holder.getAdapterPosition());
                    intent.putExtra("title", bean.getName());
                    intent.putExtra("tid", bean.getTid());
                    parent.getContext().startActivity(intent);
                });
                return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_HEAD:
                ((TextViewHolder) holder).bind(titleMap.get(position).getName());
                break;
            case VIEW_TYPE_CONTENT:
                ((ContentViewHolder) holder).bind(typeMap.get(position).getName(), typeMap.get(position).getPicture());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return typeMap.size() + titleMap.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (titleMap.containsKey(position))
            return VIEW_TYPE_HEAD;
        else
            return VIEW_TYPE_CONTENT;
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

        void bind(String text, String id) {
            textView.setText(text);
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + id).into(circleImageView);
        }
    }
}
