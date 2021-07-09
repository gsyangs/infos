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
 * 时间:2021/6/29 11
 * 邮箱 894417048@qq.com
 * viewModel databinding
 */
public abstract class BaseVMlActivity<DB extends ViewDataBinding , VM extends BaseViewModel> extends AppCompatActivity implements IBaseVmView<DB , VM> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DB db = DataBindingUtil.setContentView(this,getLayoutId());
        //建立感应
        db.setLifecycleOwner(this);
        getLifecycle().addObserver(CustomNetworkStateManager.getInstance());
        initView(db);
    }


    @Override
    public void showMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public VM createViewModel(Class cls) {
        return (VM) new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(cls);
    }

}