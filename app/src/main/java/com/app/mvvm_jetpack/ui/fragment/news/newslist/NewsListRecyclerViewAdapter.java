package com.app.mvvm_jetpack.ui.fragment.news.newslist;

import android.view.ViewGroup;

import com.app.base.customview.BaseCustomViewModel;
import com.app.base.recyclerview.BaseViewHolder;
import com.app.mvvm_jetpack.ui.common.pictureview.PictureView;
import com.app.mvvm_jetpack.ui.common.pictureview.PictureViewViewModel;
import com.app.mvvm_jetpack.ui.common.titleview.TitleView;
import com.app.mvvm_jetpack.ui.common.titleview.TitleViewViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author:create by ys
 * 时间:2021/7/19 14
 * 邮箱 894417048@qq.com
 */
public class NewsListRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final int VIEW_TYPE_PICTURE_TITLE = 1;
    private final int VIEW_TYPE_TITLE = 2;
    private List<BaseCustomViewModel> items;

    void setData(List<BaseCustomViewModel> items){
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (items != null){
            return items.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_PICTURE_TITLE){
            PictureView pictureView = new PictureView(parent.getContext());
            return new BaseViewHolder(pictureView);
        } else if (viewType == VIEW_TYPE_TITLE){
            TitleView titleView = new TitleView(parent.getContext());
            return new BaseViewHolder(titleView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof TitleViewViewModel){
            return VIEW_TYPE_TITLE;
        } else if (items.get(position) instanceof PictureViewViewModel){
            return VIEW_TYPE_PICTURE_TITLE;
        }
        return -1;
    }
}