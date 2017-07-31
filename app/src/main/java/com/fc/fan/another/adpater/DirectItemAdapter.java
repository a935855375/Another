package com.fc.fan.another.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.module.mine.bean.DirectBean;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan on 7/30/17.
 * A nice day..
 */

public class DirectItemAdapter extends RecyclerView.Adapter {
    public static final String TAG = DirectItemAdapter.class.getSimpleName();

    private Context mContext;

    private List<DirectBean.ListBean> list;

    public DirectItemAdapter(List<DirectBean.ListBean> list) {
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

        void bind(DirectBean.ListBean bean) {
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getPicture()).into(title_image);
            title.setText(bean.getName());
            describe.setText(bean.getSummary());
            click_count.setText(bean.getTime().getYear() + "-" + bean.getTime().getMonth() + "-" + bean.getTime().getDay());
        }
    }
}
