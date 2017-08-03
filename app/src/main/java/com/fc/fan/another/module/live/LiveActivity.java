package com.fc.fan.another.module.live;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CourseAdapter;
import com.fc.fan.another.module.common.TestFragment;
import com.fc.fan.another.utils.MediaUtils;

import java.util.ArrayList;
import java.util.List;


public class LiveActivity extends AppCompatActivity {
    public static final String TAG = LiveActivity.class.getSimpleName();

    private Context mContext;
    private View rootView;
    private PlayerView player;
    CourseAdapter adapter;

    ViewPager viewPager;

    List<VideoijkBean> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        rootView = LayoutInflater.from(this).inflate(R.layout.activity_live, null);
        setContentView(rootView);
        list = new ArrayList<>();
        initPlayer();
        initView();
    }

    private void initView() {
        viewPager = rootView.findViewById(R.id.live_viewPager);
        TabLayout tabLayout = rootView.findViewById(R.id.live_tab);

        adapter = new CourseAdapter(getSupportFragmentManager());

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        TalkFragment f1 = TalkFragment.newInstance();
        adapter.addTab(f1, "问题讨论");
        TestFragment f2 = TestFragment.newInstance("1");
        adapter.addTab(f2, "课堂练习");
        viewPager.setAdapter(adapter);

        VideoijkBean m = new VideoijkBean();
        m.setStream("原画");
        m.setUrl("http://flv3.bn.netease.com/tvmrepo/2017/8/4/3/ECPVR5F43/SD/ECPVR5F43-mobile.mp4");
        list.add(m);
        player.setPlaySource(list);
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
        }.setTitle("测试")
                .setProcessDurationOrientation(PlayStateParams.PROCESS_PORTRAIT)
                .setScaleType(PlayStateParams.fillparent)
                .forbidTouch(false)
                .hideSteam(true)
                .hideCenterPlayer(true)
                .hideSeekBar()
                /*.showThumbnail(ivThumbnail -> Glide.with(mContext)
                        .load("http://pic2.nipic.com/20090413/406638_125424003_2.jpg")
                        .placeholder(R.color.white)
                        .error(R.color.red)
                        .into(ivThumbnail))*/
                .setChargeTie(true, 60);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
        MediaUtils.muteAudioFocus(mContext, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
        MediaUtils.muteAudioFocus(mContext, false);
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
    }
}
