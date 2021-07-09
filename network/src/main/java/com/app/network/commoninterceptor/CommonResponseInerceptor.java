package com.app.network.commoninterceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author:create by ys
 * 时间:2021/7/5 14
 * 邮箱 894417048@qq.com
 */
public class CommonResponseInerceptor implements Interceptor {

    private static String TAG = "CommonResponseInerceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        long requestTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        //请求之后 拦截操作
        Log.d(TAG, "requestTime: " + (System.currentTimeMillis() - requestTime));
        return response;
    }
}