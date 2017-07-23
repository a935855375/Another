package com.fc.fan.another.module.entry;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.support.design.widget.TabLayout;
import android.widget.LinearLayout;

import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CourseAdapter;
import com.fc.fan.another.utils.MediaUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 7/17/17.
 */

public class CourseActivity extends AppCompatActivity {

    private Context mContext;
    View rootView;
    private PlayerView player;
    String url, title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        rootView = LayoutInflater.from(this).inflate(R.layout.activity_course, null);
        setContentView(rootView);
        Intent intent = getIntent();
        url = intent.getStringExtra("Url");
        title = intent.getStringExtra("Title");
        initPlayer();
        initView();
    }

    private void initView() {
        ViewPager viewPager = rootView.findViewById(R.id.course_viewPager);
        TabLayout tabLayout = rootView.findViewById(R.id.course_tabLayout);

        CourseAdapter adapter = new CourseAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.post(() -> setIndicator(tabLayout, 40, 40));

        player.startPlay();
    }

    private void initPlayer() {
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
            //比较Activity根布局与当前布局的大小
            int heightDiff = rootView.getRootView().getHeight() - rootView.getHeight();
            if (heightDiff > 100) {
                //大小超过100时，一般为显示虚拟键盘事件
                rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            } else {
                //大小小于100时，为不显示虚拟键盘或虚拟键盘隐藏
                rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        List<VideoijkBean> list = new ArrayList<VideoijkBean>();
        VideoijkBean m1 = new VideoijkBean();
        m1.setStream("原画");
        m1.setUrl(url);
        list.add(m1);
        player = new PlayerView(this, rootView) {
            @Override
            public PlayerView toggleProcessDurationOrientation() {
                hideSteam(getScreenOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                return setProcessDurationOrientation(getScreenOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT ? PlayStateParams.PROCESS_PORTRAIT : PlayStateParams.PROCESS_LANDSCAPE);
            }

            @Override
            public PlayerView setPlaySource(List<VideoijkBean> list) {
                return super.setPlaySource(list);
            }
        }.setTitle(title)
                .setProcessDurationOrientation(PlayStateParams.PROCESS_PORTRAIT)
                .setScaleType(PlayStateParams.fillparent)
                .forbidTouch(false)
                .hideSteam(true)
                .hideCenterPlayer(true)
                /*.showThumbnail(ivThumbnail -> Glide.with(mContext)
                        .load("http://pic2.nipic.com/20090413/406638_125424003_2.jpg")
                        .placeholder(R.color.white)
                        .error(R.color.red)
                        .into(ivThumbnail))*/
                .setPlaySource(list)
                .setChargeTie(true, 60);
    }

    // 设置下划线长度
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        if (tabStrip != null) {
            tabStrip.setAccessible(true);
        }
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < (llTab != null ? llTab.getChildCount() : 0); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
        /**demo的内容，恢复系统其它媒体的状态*/
        MediaUtils.muteAudioFocus(mContext, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
        /**demo的内容，暂停系统其它媒体的状态*/
        MediaUtils.muteAudioFocus(mContext, false);
        /**demo的内容，激活设备常亮状态*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
        /**demo的内容，恢复设备亮度状态*/
    }
}
