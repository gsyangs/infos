package com.app.mvvm_jetpack.base;

import android.os.Bundle;
import android.widget.Toast;

import com.app.mvvm_jetpack.common.CustomNetworkStateManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author:create by ys
 * 时间:2021/6/28 17
 * 邮箱 894417048@qq.com
 */
public abstract class BaseActivity<DB extends ViewDataBinding> extends AppCompatActivity implements IBaseView<DB> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DB db = DataBindingUtil.setContentView(this,getLayoutId());
        getLifecycle().addObserver(CustomNetworkStateManager.getInstance());
        initView(db);
    }


    @Override
    public void showMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}