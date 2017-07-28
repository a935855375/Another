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
import com.fc.fan.another.module.course.CourseActivity;
import com.fc.fan.another.module.region.RegionItemBean;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseItemAdapter extends RecyclerView.Adapter {
    public static String TAG = CourseItemAdapter.class.getSimpleName();

    private Context mContext;
    private HashMap<Integer, RegionItemBean.ListBean> map;

    public CourseItemAdapter() {
        map = new HashMap<>();
    }

    public void setRegionItemBean(RegionItemBean regionItemBean) {
        int q = 0;
        for (RegionItemBean.ListBean listBean : regionItemBean.getList()) {
            map.put(q, listBean);
            q++;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.region_content_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(view1 -> {
            RegionItemBean.ListBean bean = map.get(holder.getAdapterPosition());
            Intent intent = new Intent(mContext, CourseActivity.class);
            intent.putExtra("Title", bean.getName());
            intent.putExtra("Cid", bean.getCid());
            mContext.startActivity(intent);
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(map.get(position));
    }

    @Override
    public int getItemCount() {
        return map.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.content_title_image)
        ImageView titleImage;

        @BindView(R.id.content_title)
        TextView title;

        @BindView(R.id.content_describe)
        TextView describe;

        @BindView(R.id.content_click_count)
        TextView clickCount;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(RegionItemBean.ListBean listBean) {
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + listBean.getPicture()).into(titleImage);
            title.setText(listBean.getName());
            describe.setText(listBean.getSummary());
            clickCount.setText(listBean.getPeople() + "人学习");
        }
    }
}
