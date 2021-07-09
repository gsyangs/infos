package com.app.mvvm_jetpack.base;

import com.app.mvvm_jetpack.view.dialog.DialogBean;
import com.app.mvvm_jetpack.view.dialog.DialogLiveData;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

/**
 * @author:create by ys
 * 时间:2021/6/29 10
 * 邮箱 894417048@qq.com
 */
public class BaseViewModel extends ViewModel {

    DialogLiveData<DialogBean> sDialog = new DialogLiveData<>();

    protected MutableLiveData<Object> error = new MutableLiveData<>();

    /**
     * 加载dialog vm 通知 v
     * @param owner
     * @param observer
     */
    public void getShowDialog(LifecycleOwner owner, Observer<DialogBean> observer) {
        sDialog.observe(owner, observer);
    }

    /**
     * 错误信息vm 通知 v
     * @param owner
     * @param observer
     */
    public void getError(LifecycleOwner owner, Observer<Object> observer) {
        error.observe(owner, observer);
    }

    /**
     * vm 销毁时 其他操作清空
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        sDialog = null;
        error = null;
    }
}