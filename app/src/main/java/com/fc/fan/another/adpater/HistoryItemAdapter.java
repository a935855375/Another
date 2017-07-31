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
import com.fc.fan.another.module.mine.bean.HistoryBean;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan on 7/30/17.
 * A nice day..
 */

public class HistoryItemAdapter extends RecyclerView.Adapter {
    public static final String TAG = HistoryItemAdapter.class.getSimpleName();

    private Context mContext;

    private List<HistoryBean.ListBean> list;

    public HistoryItemAdapter(List<HistoryBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.history_item,
                parent, false));
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

        @BindView(R.id.history_title_image)
        ImageView title_image;

        @BindView(R.id.history_title)
        TextView title;

        @BindView(R.id.history_describe)
        TextView describe;

        @BindView(R.id.history_click_count)
        TextView click_count;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(HistoryBean.ListBean bean) {
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getPicture()).into(title_image);
            title.setText(bean.getName());
            describe.setText(bean.getSummary());
            click_count.setText(bean.getPeople() + "人学习");
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(mContext, CourseActivity.class);
                intent.putExtra("Title", bean.getName());
                intent.putExtra("Cid", bean.getCid());
                mContext.startActivity(intent);
            });
        }
    }
}
