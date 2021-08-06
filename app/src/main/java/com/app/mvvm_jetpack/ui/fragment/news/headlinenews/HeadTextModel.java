package com.app.mvvm_jetpack.ui.fragment.news.headlinenews;

import android.util.Log;

import com.app.base.IBaseModelListener;
import com.app.base.customview.BaseCustomViewModel;
import com.app.mvvm_jetpack.api.NetworkApiInterface;
import com.app.mvvm_jetpack.config.RequestParam;
import com.app.mvvm_jetpack.data.bean.ChannelListBean;
import com.app.mvvm_jetpack.data.bean.TitleRequestBean;
import com.app.network.OpenNetwork;
import com.app.network.beans.BaseResponse;
import com.app.network.observer.BaseObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:create by ys
 * 时间:2021/7/29 11
 * 邮箱 894417048@qq.com
 */
public class HeadTextModel {
    public List<ChannelListBean> channelListBeans = new ArrayList<>();

    private IBaseModelListener iBaseModelListener;

    public HeadTextModel(IBaseModelListener iBaseModelListener){
        this.iBaseModelListener = iBaseModelListener;
    }


    public void getChannelLists(){
        RequestParam requestParam = RequestParam.getInstance();
        OpenNetwork.getInstance().getService(NetworkApiInterface.class)
                .getTitleList(requestParam.getMap())
                .compose(OpenNetwork.getInstance().applySchedulers(new BaseObserver<BaseResponse<TitleRequestBean>>() {
                    @Override
                    public void onSuccess(BaseResponse<TitleRequestBean> listBaseResponse) {
                        if (listBaseResponse != null && listBaseResponse.getResult().getChannelList() != null){
                            channelListBeans = listBaseResponse.getResult().getChannelList();
                            iBaseModelListener.onLoadFinish(channelListBeans);
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        iBaseModelListener.onLoadFail(e.getMessage());
                    }
                }));
    }
}