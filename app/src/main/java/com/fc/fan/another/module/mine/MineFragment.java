package com.fc.fan.another.module.mine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fc.fan.another.R;
import com.fc.fan.another.base.RxLazyFragment;
import com.fc.fan.another.module.common.bean.LoginStatusBean;
import com.fc.fan.another.utils.PreferenceUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;


public class MineFragment extends RxLazyFragment {
    public static final String TAG = MineFragment.class.getSimpleName();

    @BindView(R.id.my_history)
    LinearLayout myHistory;

    @BindView(R.id.my_question)
    LinearLayout myQuestion;

    @BindView(R.id.my_answer)
    LinearLayout myAnswer;

    @BindView(R.id.setting)
    LinearLayout setting;

    @BindView(R.id.my_direction)
    LinearLayout myDirection;

    @BindView(R.id.mine_user_name)
    TextView userName;

    @BindView(R.id.mine_user_describe)
    TextView userDescribe;

    @BindView(R.id.mine_user_head)
    CircleImageView userHead;

    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    public int getLayoutResId() {
        return R.layout.mine_fragment;
    }

    @Override
    public void finishCreateView(Bundle state) {
        myHistory.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), HistoryActivity.class);
            startActivity(intent);
        });
        myQuestion.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), QuestionActivity.class);
            startActivity(intent);
        });
        myAnswer.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), AnswerActivity.class);
            startActivity(intent);
        });
        myDirection.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), DirectionActivity.class);
            startActivity(intent);
        });
        setting.setOnClickListener(view -> {
            Intent intent = new Intent(getContext(), SettingActivity.class);
            startActivity(intent);
        });
        loadData();
    }

    public void loadData() {
        Gson gson = new Gson();
        LoginStatusBean.UserBean bean = gson.fromJson(PreferenceUtil
                .getString("user", null), LoginStatusBean.UserBean.class);
        Glide.with(this).load(PreferenceUtil.baseUrl + "ff/image/" + bean.getPicture()).into(userHead);
        Log.e(TAG, PreferenceUtil.baseUrl + "ff/image/" + bean.getPicture());
        userName.setText(bean.getUsername());
        userDescribe.setText(bean.getUsername());
    }
}
