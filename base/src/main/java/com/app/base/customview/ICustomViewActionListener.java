package com.app.base.customview;

import android.view.View;

/**
 * @author:create by ys
 * 时间:2021/7/19 15
 * 邮箱 894417048@qq.com
 */
public interface ICustomViewActionListener {

    public static String ACTION_ROOT_VIEW_CLICKED = "onClicked";

    void onAction(String action, View view,BaseCustomViewModel viewModel);

} 