package com.app.mvvm_jetpack.data.bean;

import java.util.List;

/**
 * @author:create by ys
 * 时间:2021/7/9 16
 * 邮箱 894417048@qq.com
 */
public class NewsInfoRequestBean {

    private int ret_code;
    private PagebeanBean pagebean;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public PagebeanBean getPagebean() {
        return pagebean;
    }

    public void setPagebean(PagebeanBean pagebean) {
        this.pagebean = pagebean;
    }

}