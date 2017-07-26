package com.fc.fan.another.adpater;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhouwei.library.CustomPopWindow;
import com.fc.fan.another.R;
import com.fc.fan.another.module.explore.CommentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by fan on 7/26/17.
 * A nice day..
 */

public class CommentAdapter extends RecyclerView.Adapter {
    public static final String TAG = CommentAdapter.class.getSimpleName();

    private Context mContext;
    private CommentActivity activity;

    public CommentAdapter(CommentActivity activity) {
        this.activity = activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.comment_item_view_holder, parent, false);
        RecyclerView.ViewHolder holder = new CommentViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CommentViewHolder) holder).bind();
    }

    @Override
    public int getItemCount() {
        return 18;
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.comment_item_head_view)
        CircleImageView headView;

        @BindView(R.id.comment_author)
        TextView author;

        @BindView(R.id.comment_content)
        TextView content;

        @BindView(R.id.comment_time)
        TextView time;

        public CommentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(activity.getEdit().getWindowToken(), 0);
                View testView = LayoutInflater.from(mContext).inflate(R.layout.comment_pop_menu, null);
                LinearLayout dd = testView.findViewById(R.id.comment_copy);

                CustomPopWindow pop = new CustomPopWindow.PopupWindowBuilder(mContext)
                        .setView(testView)
                        .enableBackgroundDark(true)
                        .setBgDarkAlpha(0.7f)
                        .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                        .create()
                        .showAtLocation(itemView.getRootView(), Gravity.BOTTOM, 0, 0);

                dd.setOnClickListener(v -> {
                    Log.e(TAG, "ggggggggggg");
                    pop.dissmiss();
                });
            });
        }

        public void bind() {
            headView.setImageResource(R.drawable.logo);
            author.setText("这个是作者");
            author.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            content.setText("这里是很长的评论内容，很长很长很长很长很长很长很长很长很长很长很长很长很长很" +
                    "很长很长很长很长很长很长很长");
            time.setText("07-22");
        }
    }
}
