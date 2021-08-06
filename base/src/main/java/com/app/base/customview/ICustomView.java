package com.app.base.customview;

/**
 * @author:create by ys
 * 时间:2021/7/19 15
 * 邮箱 894417048@qq.com
 */
public interface ICustomView<S extends BaseCustomViewModel> {

    void setData(S data);

    void setActionListener(ICustomViewActionListener listener);

} 