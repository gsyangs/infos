package com.app.mvvm_jetpack.project;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author:create by ys
 * 时间:2021/6/26 12
 * 邮箱 894417048@qq.com
 */
public class ProjectViewModel extends ViewModel {

    //APP是否存活
    private MutableLiveData<Boolean> isActive;
    //APP是否登录
    private MutableLiveData<Boolean> isLogin;

    public MutableLiveData<Boolean> getIsActive() {
        if (isActive == null){
            isActive = new MutableLiveData<>();
            isActive.setValue(false);
        }
        return isActive;
    }

    public MutableLiveData<Boolean> getIsLogin() {
        if (isLogin == null){
            isLogin = new MutableLiveData<>();
            isLogin.setValue(false);
        }
        return isLogin;
    }

}