package com.fc.fan.another.utils;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by fan on 7/10/17.
 */

public interface ApiService {
    @GET("/haha")
    Observable<ResponseBody> get();

    @POST("/haha")
    Observable<ResponseBody> post(@Body RequestBody body);
}
