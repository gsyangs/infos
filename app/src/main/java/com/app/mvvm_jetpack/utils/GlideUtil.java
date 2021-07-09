package com.app.mvvm_jetpack.utils;

import android.content.Context;
import android.widget.ImageView;

import com.app.mvvm_jetpack.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Snow on 2017/2/23.
 * Description:
 */

public class GlideUtil {

    public static void displayImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .dontAnimate()
                .error(R.mipmap.ic_image_default)
                .placeholder(R.mipmap.ic_image_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void displayImage(Context context, int drawId, ImageView imageView) {
        Glide.with(context)
                .load(drawId)
                .dontAnimate()
                .error(R.mipmap.ic_image_default)
                .placeholder(R.mipmap.ic_image_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
