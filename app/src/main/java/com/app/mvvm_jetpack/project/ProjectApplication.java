package com.app.mvvm_jetpack.project;

import android.app.Activity;
import android.app.Application;

import com.app.mvvm_jetpack.config.NetworkRequiredInfo;
import com.app.network.base.NetworkApi;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/**
 * @author:create by ys
 * 时间:2021/6/26 11
 * 邮箱 894417048@qq.com
 */
public class ProjectApplication extends Application implements ViewModelStoreOwner {

    private ViewModelStore mAppViewModelStore;
    private ViewModelProvider.Factory mFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkApi.init(new NetworkRequiredInfo());
        //全局的viewmodel
        this.mAppViewModelStore = new ViewModelStore();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }

    /**
     * 暴露出去给外界使用， 确保整个项目唯一一份
     * @param activity
     * @return
     */
    public ViewModelProvider getAppViewModelProvider(Activity activity) {
        ProjectApplication projectApplication = (ProjectApplication)activity.getApplicationContext();
        if (mFactory == null){
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(projectApplication);
        }
        return new ViewModelProvider(projectApplication.getViewModelStore(),mFactory);
    }

}