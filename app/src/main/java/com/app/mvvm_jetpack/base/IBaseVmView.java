package com.app.mvvm_jetpack.base;

import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

/**
 * @author:create by ys
 * 时间:2021/6/28 17
 * 邮箱 894417048@qq.com
 */
public interface IBaseVmView<DB extends ViewDataBinding,VM extends ViewModel> {

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

    /**
     * 初始化viewModel
     * @param cls
     * @return
     */
    VM createViewModel(Class cls);
}