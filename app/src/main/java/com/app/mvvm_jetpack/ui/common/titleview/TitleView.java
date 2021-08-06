package com.app.mvvm_jetpack.ui.common.titleview;

import android.content.Context;
import android.view.View;

import com.app.base.customview.BaseCustomView;
import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.databinding.TitleViewBinding;

/**
 * @author:create by ys
 * 时间:2021/7/19 11
 * 邮箱 894417048@qq.com
 */
public class TitleView extends BaseCustomView<TitleViewBinding, TitleViewViewModel> {


    public TitleView(Context context) {
        super(context);
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.title_view;
    }

    @Override
    protected void setDataToView(TitleViewViewModel data) {
        getDataBinding().setViewModel(data);
    }

    @Override
    protected void onRootClick(View view) {
        //点击事件
    }

}