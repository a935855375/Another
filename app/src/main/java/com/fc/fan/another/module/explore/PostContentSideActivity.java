package com.fc.fan.another.module.explore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.PreferenceUtil;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fan on 7/27/17.
 * A nice day..
 */

public class PostContentSideActivity extends RxBaseActivity {
    public static final String TAG = PostContentSideActivity.class.getSimpleName();

    @BindView(R.id.post_content_side_toolbar)
    Toolbar toolbar;

    @BindView(R.id.post_content_view)
    TextView textView;

    @BindView(R.id.post_comment_side)
    LinearLayout comment_button;

    @BindView(R.id.post_content_side_author_image)
    CircleImageView author_image;

    @BindView(R.id.post_content_side_author_name)
    TextView author_name;

    @BindView(R.id.post_content_side_author_describe)
    TextView author_describe;

    @BindView(R.id.post_comment_count)
    TextView commentCount;

    private ExplorePostBean.ListBean bean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_post_side_content;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Bundle args = getIntent().getBundleExtra("args");
        bean = (ExplorePostBean.ListBean) args.getSerializable("bean");

        assert bean != null;

        Glide.with(this).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getUser().getPicture()).into(author_image);

        author_name.setText(bean.getUser().getUsername());

        textView.setText(bean.getContent());

        commentCount.setText(bean.getCommentNumber() + "");

        comment_button.setOnClickListener(view -> {
            Intent intent = new Intent(this, CommentActivity.class);
            intent.putExtra("qid", bean.getQid());
            startActivity(intent);
        });
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(bean.getTitle());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
