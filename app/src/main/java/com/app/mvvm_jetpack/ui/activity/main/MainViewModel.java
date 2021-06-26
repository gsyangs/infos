package com.app.mvvm_jetpack.ui.activity.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * @author:create by ys
 * 时间:2021/6/26 09
 * 邮箱 894417048@qq.com
 */
public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<String> liveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getLiveData() {
        if (liveData == null){
            liveData = new MutableLiveData<>();
            liveData.setValue("设置个默认值");
        }
        return liveData;
    }
}