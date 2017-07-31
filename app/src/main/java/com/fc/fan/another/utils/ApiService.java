package com.fc.fan.another.utils;

import com.fc.fan.another.module.common.bean.LoginStatusBean;
import com.fc.fan.another.module.course.ResourceBean;
import com.fc.fan.another.module.explore.ExplorePostBean;
import com.fc.fan.another.module.explore.ExploreRegionBean;
import com.fc.fan.another.module.explore.PostCommentBean;
import com.fc.fan.another.module.explore.ResposeBean;
import com.fc.fan.another.module.mine.bean.AnswerBean;
import com.fc.fan.another.module.mine.bean.DirectBean;
import com.fc.fan.another.module.mine.bean.HistoryBean;
import com.fc.fan.another.module.region.RegionBean;
import com.fc.fan.another.module.region.RegionItemBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @FormUrlEncoded
    @POST("/Fc/login/test2")
    Observable<ResponseBody> test(@Field("username") String username, @Field("password") String password);

    @GET("ff/types/types_goCourseIndex.action")
    Observable<List<RegionBean>> getRegion();

    @GET("ff/types/types_selectCoursePageByTid")
    Observable<RegionItemBean> getRegionItem(@Query("tid") int tid, @Query("page") int page);

    @GET("ff/course/course_getCourseMessage.action")
    Observable<ResourceBean> getVideoResource(@Query("cid") int cid);

    @GET("ff/question/question_getQuestionTypeInAndroid")
    Observable<ExploreRegionBean> getExploreRegion();

    @GET("ff/question/question_getQuestionTypePage")
    Observable<ExplorePostBean> getExplorePost(@Query("page") int page, @Query("type") int type);

    @GET("ff/answer/answer_getAnswerPageByQid")
    Observable<PostCommentBean> getPostComment(@Query("page") int page, @Query("qid") int qid);

    @FormUrlEncoded
    @POST("ff/question/question_addQuestion")
    Observable<ResposeBean> postWritePostDown(@Field("title") String title,
                                              @Field("content") String content,
                                              @Field("uid") int uid,
                                              @Field("style") int style);

    @FormUrlEncoded
    @POST("ff/answer/answer_addAnswerToQuestion")
    Observable<ResposeBean> postWriteCommentDown(@Field("content") String content,
                                                 @Field("uid") int uid,
                                                 @Field("qid") int aid);

    @FormUrlEncoded
    @POST("ff/user/user_login")
    Observable<LoginStatusBean> login(@Field("username") String mail, @Field("password") String password);

    @FormUrlEncoded
    @POST("ff/user/user_login")
    Observable<ResposeBean> register(@Field("username") String username, @Field("mail") String mail, @Field("password") String password);

    @GET("ff/ajax/courseuser_getCoursePageByUid")
    Observable<HistoryBean> getHistory(@Query("page") int page, @Query("uid") int uid);

    @GET("ff/ajax/question_getQuestionPageByUid")
    Observable<ExplorePostBean> getQuestion(@Query("page") int page, @Query("uid") int uid);

    @GET("ff/ajax/answer_getAnswerByUid")
    Observable<AnswerBean> getAnswer(@Query("page") int page, @Query("uid") int uid);

    @GET("ff/ajax/userplan_getPlanPageByUid")
    Observable<DirectBean> getMyDirection(@Query("page") int page, @Query("uid") int uid);
}
