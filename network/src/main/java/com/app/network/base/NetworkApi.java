package com.app.network.base;


import com.app.network.commoninterceptor.CommonResponseInerceptor;
import com.app.network.errorhandler.HttpErrorHandler;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author:create by ys
 * 时间:2021/7/5 14
 * 邮箱 894417048@qq.com
 */
public abstract class NetworkApi {

    private String BaseUrl;
    private static INetworkRequiredInfo iNetworkRequiredInfo;
    private static Map<String,Retrofit> retrofitMap = new HashMap<>();

    protected NetworkApi(String baseUrl){
        this.BaseUrl = baseUrl;
    }

    public static void init(INetworkRequiredInfo requiredInfo){
        iNetworkRequiredInfo = requiredInfo;
    }

    protected Retrofit getRetrofit(Class service){
        if (retrofitMap.get(BaseUrl + service.getName()) != null){
            return retrofitMap.get(BaseUrl + service.getName());
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseUrl)
                .client(okHttpClient())
                .addConverterFactory(GsonConverterFactory.create())//返回值转换成Gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//call 转 Observable
                .build();
        retrofitMap.put(BaseUrl + service.getName(),retrofit);
        return retrofit;
    }


    /**
     * okHttpClient
     * @return
     */
    private OkHttpClient okHttpClient(){
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        if (iNetworkRequiredInfo != null && iNetworkRequiredInfo.isDebug()){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
                    .addInterceptor(getInterceptor(iNetworkRequiredInfo))
                    .addInterceptor(new CommonResponseInerceptor());
        }
        return okHttpClientBuilder.build();
    }

    /**
     * 使用rxjava的transformer
     */
    public <T> ObservableTransformer<T,T> applySchedulers(Observer<T> observer){
        return upstream -> {
            Observable<T> observable = upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())//切换到主线程
                    .map(getAppErrorHandler())//判断是否油醋五 转换服务端返回的错误
                    .onErrorResumeNext(new HttpErrorHandler<T>());//处理错误  系统错误会自动获取
            observable.subscribe(observer);//绑定
            return observable;
        };
    }
    /**
     * 拦截器 添加头部公用参数
     */
    protected abstract Interceptor getInterceptor(INetworkRequiredInfo requiredInfo);

    /**
     * rxjava  map 转换服务端返回的错误
     */
    protected abstract  <T> Function<T,T> getAppErrorHandler();

} 