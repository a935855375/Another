package com.fc.fan.another.module.course;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.fc.fan.another.R;
import com.fc.fan.another.adpater.CourseAdapter;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.MediaUtils;
import com.fc.fan.another.utils.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class CourseActivity extends AppCompatActivity {
    public static final String TAG = CourseActivity.class.getSimpleName();

    private Context mContext;
    private View rootView;
    private PlayerView player;
    private String title;
    private int cid;

    CourseAdapter adapter;
    ChapterFragment chapterFragment;
    DetailFragment detailFragment;

    ViewPager viewPager;

    List<VideoijkBean> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        rootView = LayoutInflater.from(this).inflate(R.layout.activity_course, null);
        setContentView(rootView);
        Intent intent = getIntent();
        cid = intent.getIntExtra("Cid", 0);
        title = intent.getStringExtra("Title");
        list = new ArrayList<>();
        initPlayer();
        initView();
    }

    private void initView() {
        viewPager = rootView.findViewById(R.id.course_viewPager);
        TabLayout tabLayout = rootView.findViewById(R.id.course_tabLayout);

        adapter = new CourseAdapter(getSupportFragmentManager());

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        chapterFragment = ChapterFragment.newInstance();
        adapter.addTab(chapterFragment, "章节");
        detailFragment = DetailFragment.newInstance();
        adapter.addTab(detailFragment, "详情");
        viewPager.setAdapter(adapter);

        getData();

    }

    public void notifyChanged(ResourceBean.ResourceListBean bean) {
        detailFragment.setContent(bean.getSummary());
        list.clear();
        VideoijkBean m = new VideoijkBean();
        m.setStream("原画");
        m.setUrl(PreferenceUtil.baseUrl + "ff/video/" + bean.getPath());
        list.add(m);
        player.setPlaySource(list);
        player.startPlay();
    }

    private void getData() {
        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .getVideoResource(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::finishLoad, throwable -> Log.e(TAG, throwable.getMessage()));
    }

    private void finishLoad(ResourceBean bean) {
        if (bean.getResourceList().size() > 0) {
            initVideoView(bean.getResourceList());
            initOfficeView(bean.getOfficList());
        } else {
            Toast.makeText(this, "sorry,该课程暂时还没有任何资源..", Toast.LENGTH_SHORT).show();
        }
    }

    private void initVideoView(List<ResourceBean.ResourceListBean> videoList) {
        chapterFragment.setResource(videoList);
    }

    private void initOfficeView(List<ResourceBean.OfficListBean> officeList) {
        detailFragment.setResource(officeList);
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
                .setChargeTie(true, 60);
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
