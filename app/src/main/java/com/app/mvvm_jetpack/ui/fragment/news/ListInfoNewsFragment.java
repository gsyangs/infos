package com.app.mvvm_jetpack.ui.fragment.news;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.api.NetworkApiInterface;
import com.app.mvvm_jetpack.base.BaseFragment;
import com.app.mvvm_jetpack.config.RequestParam;
import com.app.mvvm_jetpack.data.bean.NewsInfoRequestBean;
import com.app.mvvm_jetpack.data.bean.TitleRequestBean;
import com.app.mvvm_jetpack.databinding.FragmentListInfoNewsBinding;
import com.app.network.OpenNetwork;
import com.app.network.beans.BaseResponse;
import com.app.network.observer.BaseObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

/**
 * @author:create by ys
 * 时间:2021/6/26 14
 * 邮箱 894417048@qq.com
 */
public class ListInfoNewsFragment extends BaseFragment<FragmentListInfoNewsBinding> {

    private static String TAG = "ListInfoNewsFragment";

    @Override
    public int getLayoutId() {
        return R.layout.fragment_list_info_news;
    }

    @Override
    public void initView(FragmentListInfoNewsBinding bindView) {
        RequestParam requestParam = RequestParam.getInstance();
        OpenNetwork.getInstance().getService(NetworkApiInterface.class)
                .getNewsList(requestParam.getMap())
                .compose(OpenNetwork.getInstance().applySchedulers(new BaseObserver<BaseResponse<NewsInfoRequestBean>>() {
                    @Override
                    public void onSuccess(BaseResponse<NewsInfoRequestBean> listBaseResponse) {
                        System.out.println(listBaseResponse.getResult().toString());
                        Log.d(TAG, "onSuccess: " + listBaseResponse.getCode());
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        Log.d(TAG, "onFailure: " + e.getMessage());
                    }
                }));
    }
}