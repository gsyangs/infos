package com.app.base;

/**
 * @author:create by ys
 * 时间:2021/7/29 16
 * 邮箱 894417048@qq.com
 */
public interface IBaseModelListener<T> {

    void onLoadFinish(T data, PagingResult... pagingResult);

    void onLoadFail(String prompt, Object... pagingResult);

} 