package com.app.mvvm_jetpack.ui.fragment.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.baselib.base.BaseFragment;
import com.app.mvvm_jetpack.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author:create by ys
 * 时间:2021/6/26 14
 * 邮箱 894417048@qq.com
 */
public class ImageNewsFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_news,container,false);
    }
}