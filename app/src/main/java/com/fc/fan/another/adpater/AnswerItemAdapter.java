package com.fc.fan.another.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.module.common.bean.LoginStatusBean;
import com.fc.fan.another.module.mine.bean.AnswerBean;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fan on 7/31/17.
 * A nice day..
 */

public class AnswerItemAdapter extends RecyclerView.Adapter {
    public static final String TAG = AnswerItemAdapter.class.getSimpleName();

    private Context mContext;

    private List<AnswerBean.ListBean> list;

    private LoginStatusBean.UserBean userBean;

    public AnswerItemAdapter(List<AnswerBean.ListBean> list, LoginStatusBean.UserBean bean) {
        this.list = list;
        this.userBean = bean;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.answer_item,
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

        @BindView(R.id.answer_head_image)
        CircleImageView headImage;

        @BindView(R.id.answer_username)
        TextView userName;

        @BindView(R.id.answer_time)
        TextView time;

        @BindView(R.id.answer_content)
        TextView content;

        @BindView(R.id.answer_post)
        TextView postTitle;

        @BindView(R.id.answer_comment_count)
        TextView comment_count;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(AnswerBean.ListBean bean) {
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + userBean.getPicture()).into(headImage);
            userName.setText(userBean.getUsername());
            time.setText(bean.getTime().getYear() + "-" + bean.getTime().getMonth() + "-" + bean.getTime().getDay());
            content.setText("回答：" + bean.getContent());
            postTitle.setText("问题：" + bean.getQuestion().getTitle());
            comment_count.setText(bean.getQuestion().getCommentNumber() + "评论");
        }
    }
}
