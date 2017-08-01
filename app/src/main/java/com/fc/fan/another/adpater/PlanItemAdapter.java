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
import com.fc.fan.another.module.entry.PlanBean;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan on 8/1/17.
 * A nice day..
 */

public class PlanItemAdapter extends RecyclerView.Adapter {
    public static final String TAG = PlanItemAdapter.class.getSimpleName();

    private Context mContext;

    private List<PlanBean.CoursesBean> list;

    public PlanItemAdapter(List<PlanBean.CoursesBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.region_content_item, parent, false));
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

        void bind(PlanBean.CoursesBean listBean) {
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + listBean.getPicture()).into(titleImage);
            title.setText(listBean.getName());
            describe.setText(listBean.getSummary());
            clickCount.setText(listBean.getPeople() + "人学习");
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(mContext, CourseActivity.class);
                intent.putExtra("Title", listBean.getName());
                intent.putExtra("Cid", listBean.getCid());
                mContext.startActivity(intent);
            });
        }
    }
}
