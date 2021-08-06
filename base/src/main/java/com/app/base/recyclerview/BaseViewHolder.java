package com.app.base.recyclerview;

import android.view.View;

import com.app.base.customview.BaseCustomViewModel;
import com.app.base.customview.ICustomView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author:create by ys
 * 时间:2021/7/19 15
 * 邮箱 894417048@qq.com
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    ICustomView view;

    public BaseViewHolder(@NonNull ICustomView itemView) {
        super((View) itemView);
        this.view = itemView;
    }

    public void bind(@NonNull BaseCustomViewModel item){
        view.setData(item);
    }
}