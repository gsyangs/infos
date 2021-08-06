package com.app.mvvm_jetpack.ui.fragment.my;

import android.os.Bundle;

import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.base.BaseFragment;
import com.app.mvvm_jetpack.databinding.FragmentMyInfoNewsBinding;

import androidx.fragment.app.Fragment;

/**
 * @author:create by ys
 * 时间:2021/6/26 14
 * 邮箱 894417048@qq.com
 */
public class MyInfoFragment extends BaseFragment<FragmentMyInfoNewsBinding> {

    static MyInfoFragment myInfoFragment;

    public static Fragment newInstance(String from){
        if (myInfoFragment == null){
            myInfoFragment = new MyInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("from",from);
            myInfoFragment.setArguments(bundle);
        }
        return myInfoFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_my_info_news;
    }

    @Override
    public void initView(FragmentMyInfoNewsBinding bindView) {

    }
}