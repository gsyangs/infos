package com.app.mvvm_jetpack.api;


import com.app.mvvm_jetpack.data.bean.NewsInfoRequestBean;
import com.app.mvvm_jetpack.data.bean.TitleRequestBean;
import com.app.network.beans.BaseResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @author:create by ys
 * 时间:2021/7/5 15
 * 邮箱 894417048@qq.com
 */
public interface NetworkApiInterface {

    /**
     * 获取资讯栏目
     */
    @GET("109-34")
    Observable<BaseResponse<TitleRequestBean>> getTitleList(@QueryMap Map<String,Object> params);

    /**
     * 获取资讯列表
     */
    @FormUrlEncoded
    @POST("109-35")
    Observable<BaseResponse<NewsInfoRequestBean>> getNewsList(@FieldMap Map<String,Object> params);
} 