package com.app.baselib.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

/**
 * @author:create by ys
 * 时间:2021/6/26 15
 * 邮箱 894417048@qq.com
 */
public abstract class BaseActivity<V extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity implements IBaseView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void showMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}