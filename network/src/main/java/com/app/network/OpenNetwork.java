package com.app.network;

import com.app.network.base.INetworkRequiredInfo;
import com.app.network.base.NetworkApi;
import com.app.network.beans.BaseResponse;
import com.app.network.commoninterceptor.CommonRequestInterceptor;
import com.app.network.errorhandler.ExceptionHandle;

import java.io.IOException;

import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author:create by ys
 * 时间:2021/7/5 17
 * 邮箱 894417048@qq.com
 */
public class OpenNetwork extends NetworkApi{


    private static OpenNetwork instance;

    public static OpenNetwork getInstance() {
        if (instance == null){
            synchronized (OpenNetwork.class){
                if (instance == null){
                    instance = new OpenNetwork();
                }
            }
        }
        return instance;
    }

    protected OpenNetwork() {
        super("http://route.showapi.com/");
    }

    public <T> T getService(Class<T> service){
        return getRetrofit(service).create(service);
    }


    @Override
    protected Interceptor getInterceptor(INetworkRequiredInfo requiredInfo) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                return chain.proceed(builder.build());
            }
        };
    }


    /**
     * rxjava  map 转换服务端返回的错误
     */
    @Override
    public <T> Function<T,T> getAppErrorHandler(){
        return response -> {
            if (response instanceof BaseResponse && ((BaseResponse) response).getCode() != 0){
                ExceptionHandle.ServerException exception = new ExceptionHandle.ServerException();
                exception.code = ((BaseResponse)response).getCode();
                exception.message = ((BaseResponse)response).getErroMsg() != null ? ((BaseResponse)response).getErroMsg(): "";
                throw exception;
            }
            return response;
        };
    }
}