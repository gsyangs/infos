package com.app.mvvm_jetpack.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.mvvm_jetpack.common.CustomNetworkStateManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author:create by ys
 * 时间:2021/6/28 17
 * 邮箱 894417048@qq.com
 */
public abstract class BaseFragment<DB extends ViewDataBinding> extends Fragment implements IBaseView<DB> {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //绑定databinding
        DB db = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        getLifecycle().addObserver(CustomNetworkStateManager.getInstance());
        initView(db);

        return db.getRoot();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this.getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

}