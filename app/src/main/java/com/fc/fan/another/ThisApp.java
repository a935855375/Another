package com.fc.fan.another;

import android.app.Application;

public class ThisApp extends Application {
    public static ThisApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static ThisApp getInstance() {
        return mInstance;
    }
}
