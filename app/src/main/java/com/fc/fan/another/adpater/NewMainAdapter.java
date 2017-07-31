package com.fc.fan.another.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.widget.BannerEntity;
import com.fc.fan.another.widget.BannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fan on 7/30/17.
 * A nice day..
 */


public class NewMainAdapter extends RecyclerView.Adapter {
    public static final String TAG = NewMainAdapter.class.getSimpleName();
    public static final int BANNER = 0;
    public static final int HEADER = 1;
    public static final int CARD = 2;

    private Context mContext;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        switch (viewType) {
            case BANNER:
                return new BannerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_banner, parent, false));
            case HEADER:
                return new HeaderViewHolder(LayoutInflater.from(mContext).inflate(R.layout.main_header_item, parent, false));
            case CARD:
                return new CardViewHolder(LayoutInflater.from(mContext).inflate(R.layout.main_card_item, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case BANNER:
                ((BannerViewHolder) holder).bind();
                break;
            case HEADER:
                ((HeaderViewHolder) holder).bind();
                break;
            case CARD:
                ((CardViewHolder) holder).bind();
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return BANNER;
            case 1:
                return HEADER;
            default:
                return CARD;
        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.main_banner)
        BannerView bannerView;

        BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind() {
            List<BannerEntity> list = new ArrayList<>();
            list.add(new BannerEntity(1, "测试1", "http://imgsrc.baidu.com/imgad/pic/item/267f9e2f07082838b5168c32b299a9014c08f1f9.jpg"));
            list.add(new BannerEntity(2, "测试2", "http://pic39.nipic.com/20140312/18085061_092729513131_2.jpg"));
            list.add(new BannerEntity(3, "测试3", "http://scimg.jb51.net/allimg/150415/14-15041511223U18.jpg"));
            bannerView.build(list);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.main_header_title)
        TextView header_title;

        HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind() {
            header_title.setText("好课推荐");
        }
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.main_title)
        TextView title;

        @BindView(R.id.main_content)
        TextView content;

        @BindView(R.id.main_count)
        TextView count;

        CardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind() {
            title.setText("这是一个标题");
            content.setText("这里放的是内容");
            count.setText("1234人学习");
        }
    }
}
