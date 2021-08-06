package com.app.mvvm_jetpack.ui.fragment.news.newslist;

import com.app.base.IBaseModelListener;
import com.app.base.customview.BaseCustomView;
import com.app.base.customview.BaseCustomViewModel;
import com.app.mvvm_jetpack.api.NetworkApiInterface;
import com.app.mvvm_jetpack.config.RequestParam;
import com.app.mvvm_jetpack.data.bean.ContentlistBean;
import com.app.mvvm_jetpack.data.bean.NewsInfoRequestBean;
import com.app.mvvm_jetpack.data.bean.PagebeanBean;
import com.app.mvvm_jetpack.data.bean.TitleRequestBean;
import com.app.mvvm_jetpack.ui.common.pictureview.PictureViewViewModel;
import com.app.mvvm_jetpack.ui.common.titleview.TitleViewViewModel;
import com.app.network.OpenNetwork;
import com.app.network.beans.BaseResponse;
import com.app.network.observer.BaseObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:create by ys
 * 时间:2021/7/30 14
 * 邮箱 894417048@qq.com
 */
public class NewsListModel {

    private List<BaseCustomViewModel> baseCustomViews;

    private IBaseModelListener iBaseModelListener;

    public NewsListModel(IBaseModelListener iBaseModelListener){
        this.baseCustomViews = new ArrayList<>();
        this.iBaseModelListener = iBaseModelListener;
    }

    public void getNewsList(String channelId,String page,String maxResult){
        if ("1".equals(page)){
            baseCustomViews.clear();
        }
        RequestParam requestParam = RequestParam.getInstance();
        requestParam.setMap("channelId",channelId);
        requestParam.setMap("page",page);
        requestParam.setMap("maxResult",maxResult);
        OpenNetwork.getInstance().getService(NetworkApiInterface.class)
                .getNewsList(requestParam.getMap())
                .compose(OpenNetwork.getInstance().applySchedulers(new BaseObserver<BaseResponse<NewsInfoRequestBean>>() {
                    @Override
                    public void onSuccess(BaseResponse<NewsInfoRequestBean> newsInfoRequestBean) {
                        if (newsInfoRequestBean != null && newsInfoRequestBean.getResult().getPagebean() != null){
                            PagebeanBean pagebeanBean = newsInfoRequestBean.getResult().getPagebean();
                            List<ContentlistBean> contentlist = pagebeanBean.getContentlist();
                            for (ContentlistBean contentlistBean : contentlist){
                                if (contentlistBean.getImageurls() == null || contentlistBean.getImageurls().size() == 0){
                                    TitleViewViewModel viewModel = new TitleViewViewModel();
                                    viewModel.channelListBean = contentlistBean;
                                    baseCustomViews.add(viewModel);
                                } else {
                                    PictureViewViewModel viewModel = new PictureViewViewModel();
                                    viewModel.channelListBean = contentlistBean;
                                    baseCustomViews.add(viewModel);
                                }
                            }
                            iBaseModelListener.onLoadFinish(baseCustomViews);
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        iBaseModelListener.onLoadFail(e.getMessage());
                    }
                }));
    }
}