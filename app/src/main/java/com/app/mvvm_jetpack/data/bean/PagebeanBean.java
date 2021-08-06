package com.app.mvvm_jetpack.data.bean;

import java.util.List;

/**
 * @author:create by ys
 * 时间:2021/7/19 11
 * 邮箱 894417048@qq.com
 */
public class PagebeanBean {
    private int allPages;
    private List<ContentlistBean> contentlist;
    private int currentPage;
    private int allNum;
    private int maxResult;

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public List<ContentlistBean> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<ContentlistBean> contentlist) {
        this.contentlist = contentlist;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

}