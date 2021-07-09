package com.app.mvvm_jetpack.change;

import com.app.mvvm_jetpack.base.BaseViewModel;
import com.app.mvvm_jetpack.data.bean.TitleRequestBean;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

/**
 * @author:create by ys
 * 时间:2021/6/28 14
 * 邮箱 894417048@qq.com
 */
public class TitleViewModel extends BaseViewModel {

    private MutableLiveData<List<TitleRequestBean.ChannelListBean>> channelListBean = new MutableLiveData<>();


    public MutableLiveData<List<TitleRequestBean.ChannelListBean>> getImages() {
        if (channelListBean == null){
            channelListBean = new MutableLiveData<>();
        }
        return channelListBean;
    }

    /**
     * 网络请求
     */
    public void getData() {

    }
}