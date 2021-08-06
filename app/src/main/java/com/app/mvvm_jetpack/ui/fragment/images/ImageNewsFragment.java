package com.app.mvvm_jetpack.ui.fragment.images;


import android.os.Bundle;

import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.base.BaseVMFragment;
import com.app.mvvm_jetpack.config.RequestParam;
import com.app.mvvm_jetpack.databinding.FragmentImageNewsBinding;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * @author:create by ys
 * 时间:2021/6/26 14
 * 邮箱 894417048@qq.com
 */
public class ImageNewsFragment extends BaseVMFragment {

    private static String TAG = "ImageNewsFragment";
//    private TitleViewModel viewModel;
    private FragmentImageNewsBinding binding;


    static ImageNewsFragment imageNewsFragment;

    public static Fragment newInstance(String from){
        if (imageNewsFragment == null){
            imageNewsFragment = new ImageNewsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("from",from);
            imageNewsFragment.setArguments(bundle);
        }
        return imageNewsFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_image_news;
    }


    @Override
    public void initView(ViewDataBinding bindView) {
//        this.binding =  bindView;
//        this.viewModel = createViewModel(TitleViewModel.class);
//        this.binding.setVm(viewModel);

        RequestParam requestParam = RequestParam.getInstance();
//        OpenNetwork.getInstance().getService(NetworkApiInterface.class)
//                .getTitleList(requestParam.getMap())
//                .compose(OpenNetwork.getInstance().applySchedulers(new BaseObserver<BaseResponse<TitleRequestBean>>() {
//                    @Override
//                    public void onSuccess(BaseResponse<TitleRequestBean> listBaseResponse) {
//                        System.out.println(listBaseResponse.getResult().toString());
//                        Log.d(TAG, "onSuccess: " + listBaseResponse.getCode());
//                    }
//
//                    @Override
//                    public void onFailure(Throwable e) {
//                        Log.d(TAG, "onFailure: " + e.getMessage());
//                    }
//                }));

    }
}