package com.fc.fan.another.module.explore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class WriteDownActivity extends RxBaseActivity {
    public static final String TAG = WriteDownActivity.class.getSimpleName();

    @BindView(R.id.write_down_toolbar)
    Toolbar toolbar;

    @BindView(R.id.write_down_title)
    EditText titleEdit;

    @BindView(R.id.write_down_content)
    EditText contentEdit;

    @BindView(R.id.write_down_finished)
    ImageView doneButton;

    private int type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_write_down;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        type = getIntent().getIntExtra("type", 0);

        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        doneButton.setOnClickListener(view -> {
            if (!valid())
                return;

            Log.e(TAG, "已发送请求");

            String title = titleEdit.getText().toString();
            String content = contentEdit.getText().toString();
            int uid = 1;
            postData(title, content, uid);
        });
    }

    private void postData(String title, String content, int uid) {
        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .postWritePostDown(title, content, uid, type)
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(x -> {
                    if (x.getMsg() == 1) {
                        Toast.makeText(this, "发帖成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    } else
                        Toast.makeText(this, "发帖失败", Toast.LENGTH_SHORT).show();
                }, throwable -> {
                    Toast.makeText(this, "网络错误..", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, throwable.getMessage());
                });
    }

    private boolean valid() {
        String title = titleEdit.getText().toString();
        String content = contentEdit.getText().toString();

        boolean flag = true;

        if (title.isEmpty()) {
            Toast.makeText(this, "标题不能为空", Toast.LENGTH_SHORT).show();
            flag = false;
        }

        if (content.isEmpty()) {
            Toast.makeText(this, "请输入一些内容", Toast.LENGTH_SHORT).show();
            flag = false;
        }

        return flag;
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("提问");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }
}
