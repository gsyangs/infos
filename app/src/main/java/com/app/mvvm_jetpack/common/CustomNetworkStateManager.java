package com.app.mvvm_jetpack.common;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author:create by ys
 * 时间:2021/6/29 15
 * 邮箱 894417048@qq.com
 */
public class CustomNetworkStateManager implements LifecycleObserver {

    public static final CustomNetworkStateManager STATE_MANAGER = new CustomNetworkStateManager();

    public static CustomNetworkStateManager getInstance(){
        return STATE_MANAGER;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(@NonNull LifecycleOwner owner){
        //可见生命周期 做一些操作 比如添加监听wifi广播
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(@NonNull LifecycleOwner owner){
        //不可见生命周期做一些操作 比如移除监听wifi广播
    }
} 