package com.fc.fan.another.adpater;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.module.course.CourseActivity;
import com.fc.fan.another.module.course.ResourceBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan on 7/25/17.
 * A nice day..
 */

public class CourseChapterAdapter extends RecyclerView.Adapter {
    public static final String TAG = CourseChapterAdapter.class.getSimpleName();

    private Context mContext;
    private CourseActivity activity;
    private boolean flag;
    private ChapterViewHolder last;

    List<ResourceBean.ResourceListBean> videoList;

    public CourseChapterAdapter(List<ResourceBean.ResourceListBean> videoList, Activity activity) {
        this.videoList = videoList;
        this.activity = (CourseActivity) activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.chapter_item, parent, false);
        ChapterViewHolder holder = new ChapterViewHolder(view);
        holder.itemView.setOnClickListener(v -> {
            holder.textView.setTextColor(Color.RED);
            if (last != null)
                last.textView.setTextColor(Color.BLACK);
            last = holder;
            activity.notifyChanged(videoList.get(holder.getAdapterPosition()));
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChapterViewHolder) holder).bind(videoList.get(holder.getAdapterPosition()), holder.getAdapterPosition());
        if (holder.getAdapterPosition() == 0 && !flag) {
            holder.itemView.callOnClick();
            last = (ChapterViewHolder) holder;
            flag = true;
        }
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class ChapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.chapter_item_text)
        TextView textView;

        public ChapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(ResourceBean.ResourceListBean bean, int posistion) {
            int i = posistion + 1;
            textView.setText("▷  " + i + "、" + bean.getName());
            textView.setTextColor(Color.BLACK);
        }
    }
}
