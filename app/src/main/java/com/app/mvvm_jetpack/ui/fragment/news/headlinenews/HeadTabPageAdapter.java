package com.app.mvvm_jetpack.ui.fragment.news.headlinenews;

import com.app.mvvm_jetpack.data.bean.ChannelListBean;
import com.app.mvvm_jetpack.ui.fragment.news.newslist.NewInfoFragment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @author:create by ys
 * 时间:2021/7/19 10
 * 邮箱 894417048@qq.com
 */
public class HeadTabPageAdapter extends FragmentPagerAdapter {

    private List<ChannelListBean> mTitles;

    public HeadTabPageAdapter(@NonNull FragmentManager fm, List<ChannelListBean> mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return NewInfoFragment.newInstance(mTitles.get(position).getChannelId());
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).getName();
    }
}