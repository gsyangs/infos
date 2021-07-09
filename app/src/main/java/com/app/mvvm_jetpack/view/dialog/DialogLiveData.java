package com.app.mvvm_jetpack.view.dialog;

import androidx.lifecycle.MutableLiveData;

/**
 * @author:create by ys
 * 时间:2021/6/29 10
 * 邮箱 894417048@qq.com
 * 自定义 dialog livedata
 */
public class DialogLiveData<T> extends MutableLiveData<T> {

    private DialogBean dialogBean = new DialogBean();

    public void setValue(Boolean value) {
        dialogBean.setShow(value);
        dialogBean.setMsg("");
        setValue((T) dialogBean);
    }

    public void setValue(boolean isShow, String msg) {
        dialogBean.setShow(isShow);
        dialogBean.setMsg(msg);
        setValue((T) dialogBean);
    }
}