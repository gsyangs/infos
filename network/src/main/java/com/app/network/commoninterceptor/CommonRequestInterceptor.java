package com.app.network.commoninterceptor;

import com.app.network.base.INetworkRequiredInfo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author:create by ys
 * 时间:2021/7/5 14
 * 邮箱 894417048@qq.com
 */
public class CommonRequestInterceptor implements Interceptor {

    private INetworkRequiredInfo requiredInfo;

    public CommonRequestInterceptor(INetworkRequiredInfo requiredInfo){
        this.requiredInfo = requiredInfo;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("count",requiredInfo.getListCount());
        //请求之前拦截
        return chain.proceed(builder.build());
    }
}