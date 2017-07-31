package com.fc.fan.another.adpater;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.module.explore.ExplorePostBean;
import com.fc.fan.another.module.explore.PostContentSideActivity;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fan on 7/31/17.
 * A nice day..
 */

public class QuestionAdapter extends RecyclerView.Adapter {
    public static final String TAG = QuestionAdapter.class.getSimpleName();

    List<ExplorePostBean.ListBean> list;

    private Context mContext;

    public QuestionAdapter(List<ExplorePostBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        return new CardViewHolder(LayoutInflater.from(mContext).inflate(R.layout.explore_item_view_holder,
                parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CardViewHolder) holder).bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.explore_circleView)
        CircleImageView circleImageView;

        @BindView(R.id.explore_auth_name)
        TextView authName;

        @BindView(R.id.explore_title)
        TextView title;

        @BindView(R.id.explore_describe)
        TextView describe;

        @BindView(R.id.explore_click_count)
        TextView clickCount;

        @BindView(R.id.explore_comment_count)
        TextView commentCount;

        @BindView(R.id.pop_menu)
        ImageView menuButton;

        CardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(ExplorePostBean.ListBean bean) {
            title.setText(bean.getTitle());
            authName.setText(bean.getUser().getUsername());
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getUser().getPicture()).into(circleImageView);
            describe.setText(bean.getContent());
            clickCount.setText(bean.getLookNumber() + " 查看 · ");
            commentCount.setText(bean.getCommentNumber() + " 评论");
            title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            menuButton.setOnClickListener(view -> {
                PopupMenu popupMenu = new PopupMenu(mContext, menuButton);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());
                popupMenu.show();
            });
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(mContext, PostContentSideActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("bean", bean);
                intent.putExtra("args", args);
                mContext.startActivity(intent);
            });
            ((CardView) itemView).setRadius(0);
        }
    }
}
