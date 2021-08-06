package com.app.mvvm_jetpack.view;

import android.os.Bundle;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @author:create by ys
 * 时间:2021/6/26 17
 * 邮箱 894417048@qq.com
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;

    public ViewPagerAdapter(FragmentManager manager,List<Fragment> mFragmentList) {
        super(manager);
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = mFragmentList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("id",""+position);
        if (fragment != null) {
            fragment.setArguments(bundle);
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

} 