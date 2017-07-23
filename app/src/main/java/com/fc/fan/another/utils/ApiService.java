package com.fc.fan.another.utils;

import com.fc.fan.another.module.region.RegionBean;
import com.fc.fan.another.module.region.RegionItemBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by fan on 7/10/17.
 */

public interface ApiService {
    @GET("/haha")
    Observable<ResponseBody> get();

    @POST("/haha")
    Observable<ResponseBody> post(@Body RequestBody body);

    @FormUrlEncoded
    @POST("/Fc/login/test2")
    Observable<ResponseBody> test(@Field("username") String username, @Field("password") String password);

    @POST("/Fc/videofile_scanFileByCourse.action")
    Observable<ResponseBody> test();

    @GET("ff/types/types_goCourseIndex.action")
    Observable<List<RegionBean>> getRegion();

    @GET("ff/types/types_selectCoursePageByTid")
    Observable<RegionItemBean> getRegionItem(@Query("tid") int tid, @Query("page") int page);

}
