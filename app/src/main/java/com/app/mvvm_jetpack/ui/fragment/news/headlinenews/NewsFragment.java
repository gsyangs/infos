package com.app.mvvm_jetpack.ui.fragment.news.headlinenews;

import android.os.Bundle;

import com.app.base.IBaseModelListener;
import com.app.base.PagingResult;
import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.base.BaseFragment;
import com.app.mvvm_jetpack.data.bean.ChannelListBean;
import com.app.mvvm_jetpack.databinding.FragmentNewsBinding;

import java.util.List;

import androidx.fragment.app.Fragment;

/**
 * @author:create by ys
 * 时间:2021/6/26 14
 * 邮箱 894417048@qq.com
 */
public class NewsFragment extends BaseFragment<FragmentNewsBinding> implements IBaseModelListener<List<ChannelListBean>> {

    private static String TAG = "NewsFragment";

    static NewsFragment newsFragment;

    private FragmentNewsBinding bindView;

    HeadTextModel headTextModel = new HeadTextModel(this);


    public static Fragment newInstance(String channelId){
        if (newsFragment == null){
            newsFragment = new NewsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelId",channelId);
            newsFragment.setArguments(bundle);
        }
        return newsFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void initView(FragmentNewsBinding bindView) {
        this.bindView = bindView;
        headTextModel.getChannelLists();
    }

    @Override
    public void onLoadFinish(List<ChannelListBean> channelListBeans, PagingResult... pagingResult) {
        bindView.newsViewpager.setAdapter(new HeadTabPageAdapter(getChildFragmentManager(),channelListBeans));
        bindView.titleTabLayout.setupWithViewPager(bindView.newsViewpager);
    }

    @Override
    public void onLoadFail(String prompt, Object... pagingResult) {
        showMsg(prompt);
    }
}