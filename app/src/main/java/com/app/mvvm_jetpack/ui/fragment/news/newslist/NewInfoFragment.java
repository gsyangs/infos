package com.app.mvvm_jetpack.ui.fragment.news.newslist;

import android.os.Bundle;
import android.view.View;

import com.app.base.IBaseModelListener;
import com.app.base.PagingResult;
import com.app.base.customview.BaseCustomViewModel;
import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.base.BaseFragment;
import com.app.mvvm_jetpack.databinding.FragmentNewInfoBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * @author:create by ys
 * 时间:2021/7/19 10
 * 邮箱 894417048@qq.com
 */
public class NewInfoFragment extends BaseFragment<FragmentNewInfoBinding> implements SwipeRefreshLayout.OnRefreshListener,
        IBaseModelListener<List<BaseCustomViewModel>> {

    private static String TAG = "NewInfoFragment";
    private FragmentNewInfoBinding bindView;
    private NewsListRecyclerViewAdapter newsListRecyclerViewAdapter;
    private NewsListModel newsListModel = new NewsListModel(this);
    private String channelId;
    private int page = 1;

    public static Fragment newInstance(String channelId){
        NewInfoFragment newInfoFragment = new NewInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("channelId",channelId);
        newInfoFragment.setArguments(bundle);
        return newInfoFragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_new_info;
    }

    @Override
    public void initView(FragmentNewInfoBinding bindView) {
        this.bindView = bindView;
        this.bindView.refreshLayout.setOnRefreshListener(this);
        this.channelId = getArguments().getString("channelId");
        this.newsListRecyclerViewAdapter = new NewsListRecyclerViewAdapter();
        bindView.newsList.setHasFixedSize(true);
        bindView.newsList.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        bindView.newsList.setLayoutManager(linearLayoutManager);
        bindView.newsList.setAdapter(newsListRecyclerViewAdapter);

        newsListModel.getNewsList(channelId,"1","20");
        bindView.newsList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }

    @Override
    public void onLoadFinish(List<BaseCustomViewModel> data, PagingResult... pagingResult) {
        newsListRecyclerViewAdapter.setData(data);
        //刷新完成
        bindView.refreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadFail(String prompt, Object... pagingResult) {
        showMsg(prompt);
    }

    @Override
    public void onRefresh() {
        page = 1;
        newsListModel.getNewsList(channelId,String.valueOf(page),"20");
    }
}