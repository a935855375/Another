package com.fc.fan.another.adpater;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.module.course.ResourceBean;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan on 7/30/17.
 * A nice day..
 */

public class CourseDetailAdapter extends RecyclerView.Adapter {
    public static final String TAG = CourseItemAdapter.class.getSimpleName();

    private Context mContext;

    private List<ResourceBean.OfficListBean> list;

    public CourseDetailAdapter(List<ResourceBean.OfficListBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.course_offic_item, parent, false));
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

        @BindView(R.id.office_item_text)
        TextView textView;

        @BindView(R.id.office_download)
        ImageView download;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(ResourceBean.OfficListBean bean) {
            textView.setText(bean.getName());
            download.setOnClickListener(view -> {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(PreferenceUtil.baseUrl + "ff/otherFile/" + bean.getFilePath()));
                mContext.startActivity(intent);
            });
        }
    }
}
