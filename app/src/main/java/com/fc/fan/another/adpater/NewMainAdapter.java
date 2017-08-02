package com.fc.fan.another.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.module.course.CourseActivity;
import com.fc.fan.another.module.entry.PlanActivity;
import com.fc.fan.another.module.main.MainBean;
import com.fc.fan.another.utils.PreferenceUtil;
import com.fc.fan.another.widget.BannerEntity;
import com.fc.fan.another.widget.BannerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static final int COURSE_CARD = 2;
    public static final int PLAN_CARD = 3;

    private Context mContext;

    private List<MainBean.KyListBean> kyList;

    private Map<Integer, String> headMap;

    private Map<Integer, MainBean.PlanListBean> planMap;

    private Map<Integer, MainBean.CbBean.ListBean> courseMap;

    private Map<Integer, Integer> location;

    public static NewMainAdapter mInstance;

    public static NewMainAdapter getInstance() {
        return mInstance;
    }

    public NewMainAdapter() {
        headMap = new HashMap<>();
        planMap = new HashMap<>();
        location = new HashMap<>();
        courseMap = new HashMap<>();
        mInstance = this;
    }

    public void setMainBean(MainBean bean) {
        int q = 0;
        int w = 0;
        kyList = bean.getKyList();
        q++;
        for (MainBean.CbBean cb : bean.getCb()) {
            headMap.put(q, cb.getMsg());
            q++;
            for (MainBean.CbBean.ListBean course : cb.getList()) {
                courseMap.put(q, course);
                location.put(q, w);
                q++;
                w++;
            }
        }
        headMap.put(q, "热门计划");
        q++;
        for (MainBean.PlanListBean plan : bean.getPlanList()) {
            planMap.put(q, plan);
            location.put(q, w);
            q++;
            w++;
        }
    }

    public int getRealLocation(int q) {
        return location.get(q);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();
        switch (viewType) {
            case BANNER:
                return new BannerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_banner, parent, false));
            case HEADER:
                return new HeaderViewHolder(LayoutInflater.from(mContext).inflate(R.layout.main_header_item, parent, false));
            case COURSE_CARD:
                return new CourseViewHolder(LayoutInflater.from(mContext).inflate(R.layout.main_card_item, parent, false));
            case PLAN_CARD:
                return new PlanViewHolder(LayoutInflater.from(mContext).inflate(R.layout.main_card_item, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BANNER:
                ((BannerViewHolder) holder).bind(kyList);
                break;
            case HEADER:
                ((HeaderViewHolder) holder).bind(headMap.get(position));
                break;
            case COURSE_CARD:
                ((CourseViewHolder) holder).bind(courseMap.get(position));
                break;
            case PLAN_CARD:
                ((PlanViewHolder) holder).bind(planMap.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return BANNER;
        else if (headMap.containsKey(position))
            return HEADER;
        else if (planMap.containsKey(position))
            return PLAN_CARD;
        else
            return COURSE_CARD;
    }

    @Override
    public int getItemCount() {
        if (kyList == null)
            return 0;
        else
            return 1 + planMap.size() + courseMap.size() + headMap.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.main_banner)
        BannerView bannerView;

        BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(List<MainBean.KyListBean> kyList) {
            List<BannerEntity> list = new ArrayList<>();
            for (int i = 0; i < kyList.size(); i++)
                list.add(new BannerEntity(i, i + "", PreferenceUtil.baseUrl + "ff/image/" + kyList.get(i).getPicture()));
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

        void bind(String title) {
            header_title.setText(title);
        }
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.main_title)
        TextView title;

        @BindView(R.id.main_content)
        TextView content;

        @BindView(R.id.main_count)
        TextView count;

        @BindView(R.id.main_back)
        ImageView back;

        CourseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(MainBean.CbBean.ListBean bean) {
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getPicture()).into(back);
            title.setText(bean.getName());
            content.setText(bean.getSummary());
            count.setText(bean.getPeople() + "人学习");
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(mContext, CourseActivity.class);
                intent.putExtra("Cid", bean.getCid());
                intent.putExtra("Title", bean.getName());
                mContext.startActivity(intent);
            });
        }
    }

    class PlanViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.main_title)
        TextView title;

        @BindView(R.id.main_content)
        TextView content;

        @BindView(R.id.main_count)
        TextView count;

        @BindView(R.id.main_back)
        ImageView back;

        PlanViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(MainBean.PlanListBean bean) {
            title.setText(bean.getName());
            Glide.with(mContext).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getPicture()).into(back);
            content.setText(bean.getSummary());
            count.setText(bean.getTime().getYear() + "-" + bean.getTime().getMonth() + "-" + bean.getTime().getDate());
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(mContext, PlanActivity.class);
                intent.putExtra("pid", bean.getPid());
                intent.putExtra("title", bean.getTitle());
                mContext.startActivity(intent);
            });
        }
    }
}
