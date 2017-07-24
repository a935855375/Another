package com.fc.fan.another.adpater;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.module.explore.ExploreActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fan on 7/23/17.
 */

public class ExploreItemAdapter extends RecyclerView.Adapter {
    public static final String TAG = ExploreActivity.class.getSimpleName();

    Context mContext;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.explore_item_view_holder, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CardViewHolder) holder).bind();
    }

    @Override
    public int getItemCount() {
        return 20;
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

        public CardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind() {
            title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            menuButton.setOnClickListener(view -> {
                PopupMenu popupMenu = new PopupMenu(mContext, menuButton);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());
                popupMenu.show();
            });
        }
    }
}
