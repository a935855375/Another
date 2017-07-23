package com.fc.fan.another.utils;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fan on 7/10/17.
 */

public class HttpUtils {
    private static HttpUtils mHttpUtils;
    private OkHttpClient.Builder mBuilder;

    public static HttpUtils getInstance() {
        if (mHttpUtils == null) {
            synchronized (HttpUtils.class) {
                if (mHttpUtils == null) {
                    mHttpUtils = new HttpUtils();
                }
            }
        }
        return mHttpUtils;
    }

    private Context context;
    private String url;

    private HttpUtils() {
        initOkhttp();
    }

    public <T> T create(Class<T> service, String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(mBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(service);
    }

    private void initOkhttp() {
        mBuilder = new OkHttpClient.Builder()
                .connectTimeout(9, TimeUnit.SECONDS)    //设置连接超时 9s
                .readTimeout(10, TimeUnit.SECONDS);      //设置读取超时 10s
    }
}
