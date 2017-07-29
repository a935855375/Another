package com.fc.fan.another.module.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fc.fan.another.utils.PreferenceUtil;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by fan on 7/12/17.
 */

public class SplashActivity extends RxActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable.timer(2, TimeUnit.SECONDS)
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> Goto());
    }

    private void Goto() {
        boolean isLogin = PreferenceUtil.getBoolean("isLogin", false);
        if (isLogin)
            startActivity(new Intent(this, MainActivity.class));
        else
            startActivity(new Intent(this, LoginActivity.class));
        this.finish();
    }
}
