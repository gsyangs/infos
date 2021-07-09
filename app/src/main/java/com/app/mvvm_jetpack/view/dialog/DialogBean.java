package com.app.mvvm_jetpack.view.dialog;

/**
 * @author:create by ys
 * 时间:2021/6/29 10
 * 邮箱 894417048@qq.com
 */
public class DialogBean {

    private boolean isShow;
    private String msg;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}