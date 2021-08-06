package com.app.base;

/**
 * @author:create by ys
 * 时间:2021/7/30 15
 * 邮箱 894417048@qq.com
 */
public class PagingResult {

    private boolean isRefresh;
    private int isEmpty;
    private boolean hasNextPage;

    public PagingResult(int isEmpty,boolean isRefresh, boolean hasNextPage){
        this.isEmpty = isEmpty;
        this.hasNextPage = hasNextPage;
        this.isRefresh = isRefresh;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }

    public int getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(int isEmpty) {
        this.isEmpty = isEmpty;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}