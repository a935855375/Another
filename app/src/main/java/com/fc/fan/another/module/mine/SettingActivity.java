package com.fc.fan.another.module.mine;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.module.common.bean.LoginStatusBean;
import com.fc.fan.another.utils.PreferenceUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fan on 7/29/17.
 * A nice day..
 */

public class SettingActivity extends RxBaseActivity {
    public static final String TAG = SettingActivity.class.getSimpleName();

    @BindView(R.id.setting_toolbar)
    Toolbar toolbar;

    @BindView(R.id.setting_auto_play)
    SwitchCompat auto_play;

    @BindView(R.id.setting_user_head)
    CircleImageView userImage;

    @BindView(R.id.setting_username)
    TextView userName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        auto_play.setChecked(true);
        Gson gson = new Gson();
        LoginStatusBean.UserBean bean = gson.fromJson(PreferenceUtil
                .getString("user", null), LoginStatusBean.UserBean.class);
        Glide.with(this).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getPicture()).into(userImage);
        userName.setText(bean.getUsername());
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("设置");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
