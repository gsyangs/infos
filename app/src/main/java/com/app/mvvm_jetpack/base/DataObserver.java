package com.app.mvvm_jetpack.base;

/**
 * @author:create by ys
 * 时间:2021/8/3 15
 * 邮箱 894417048@qq.com
 */
public interface DataObserver<F> {

    void onSuccess(F t, boolean isFromCache);
    void onFailure(Throwable e);

}