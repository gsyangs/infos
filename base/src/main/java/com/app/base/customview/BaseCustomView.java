package com.app.base.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @author:create by ys
 * 时间:2021/7/19 15
 * 邮箱 894417048@qq.com
 */
public abstract class BaseCustomView<T extends ViewDataBinding, S extends BaseCustomViewModel> extends LinearLayout implements ICustomView<S>, View.OnClickListener {

    private T dataBinding;
    private S viewModel;
    private ICustomViewActionListener listener;

    public BaseCustomView(Context context) {
        super(context);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BaseCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public View getRootView(){
        return dataBinding.getRoot();
    }

    public void init(){
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (setViewLayoutId() != 0){
            dataBinding = DataBindingUtil.inflate(inflater,setViewLayoutId(),this,false);
            dataBinding.getRoot().setOnClickListener(this);
            this.addView(dataBinding.getRoot());
        }
    }

    @Override
    public void setData(S data) {
        viewModel = data;
        setDataToView(viewModel);
        if (dataBinding != null){
            dataBinding.executePendingBindings();
        }
        onDataUpdated();
    }

    @Override
    public void setActionListener(ICustomViewActionListener listener) {
        this.listener = listener;
    }

    //设置一个布局
    protected abstract int setViewLayoutId();

    //设置数据
    protected abstract void setDataToView(S data);

    //点击事件
    protected abstract void  onRootClick(View view);

    protected T getDataBinding(){
        return dataBinding;
    }

    protected void onDataUpdated(){

    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onAction(ICustomViewActionListener.ACTION_ROOT_VIEW_CLICKED,v,viewModel);
        }
        onRootClick(v);
    }

}