package com.app.mvvm_jetpack.ui.common.pictureview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.app.base.customview.BaseCustomView;
import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.data.bean.NewImageBean;
import com.app.mvvm_jetpack.databinding.PictureViewBinding;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.databinding.BindingAdapter;

/**
 * @author:create by ys
 * 时间:2021/7/19 11
 * 邮箱 894417048@qq.com
 */
public class PictureView extends BaseCustomView<PictureViewBinding,PictureViewViewModel> {

    public PictureView(Context context) {
        super(context);
    }

    @Override
    protected int setViewLayoutId() {
        return R.layout.picture_view;
    }

    @Override
    protected void setDataToView(PictureViewViewModel data) {
        getDataBinding().setViewModel(data);
    }

    @Override
    protected void onRootClick(View view) {

    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, List<NewImageBean> urls){
        //显示图片操作
        if (urls != null && urls.size() > 0){
            NewImageBean imageBean = urls.get(0);
            Glide.with(view.getContext())
                    .load(imageBean.getUrl())
                    .into((view));
        }
    }

}