package com.app.mvvm_jetpack.base;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

/**
 * @author:create by ys
 * 时间:2021/6/28 17
 * 邮箱 894417048@qq.com
 * 无ViewModel
 */
public interface IBaseView<DB extends ViewDataBinding> {

    /**
     * 获取资源ID
     */
    int getLayoutId();

    /**
     * 初始化界面
     */
    void initView(DB bindView);

    /**
     * 弹框
     */
    void showMsg(String msg);


}