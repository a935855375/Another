package com.fc.fan.another.adpater;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.module.explore.CommentActivity;
import com.fc.fan.another.module.explore.PostCommentBean;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by fan on 7/26/17.
 * A nice day..
 */

public class CommentAdapter extends RecyclerView.Adapter {
    public static final String TAG = CommentAdapter.class.getSimpleName();

    private List<PostCommentBean.ListBean> list;

    public CommentAdapter(List<PostCommentBean.ListBean> list) {
        this.list = list;
    }

    private Context mContext;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        return new CommentViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.comment_item_view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CommentViewHolder) holder).bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
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

        CommentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(PostCommentBean.ListBean bean) {
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getUser().getPicture()).into(headView);
            author.setText(bean.getUser().getUsername());
            author.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            content.setText(bean.getContent());
            time.setText(bean.getTime().getMonth() + "-" + bean.getTime().getDay());

            itemView.setOnClickListener(v -> {
                View view = LayoutInflater.from(mContext).inflate(R.layout.comment_pop_menu, null);
                final BottomSheetDialog dialog = new BottomSheetDialog(mContext);
                EditText editText = ((CommentActivity) mContext).getEditText();
                view.findViewById(R.id.comment_reply).setOnClickListener(vv -> {
                    ((CommentActivity) mContext).getCancelButton().setVisibility(View.VISIBLE);
                    editText.setHint("回复 " + bean.getUser().getUsername() + " 的评论：");
                    dialog.cancel();
                    editText.requestFocus();
                    ((CommentActivity) mContext).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                });
                dialog.setContentView(view);
                dialog.show();
            });
        }
    }
}
