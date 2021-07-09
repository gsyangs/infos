package com.app.mvvm_jetpack.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author:create by ys
 * 时间:2021/6/29 14
 * 邮箱 894417048@qq.com
 */
public abstract class BaseVMAdapter<DB extends ViewDataBinding,VM extends BaseViewModel,T> extends RecyclerView.Adapter<BaseVMAdapter.VMViewHolder> {

    private List<T> list;
    private int resourceId;

    public BaseVMAdapter(List<T> list, int resourceId){
        this.list = list;
        this.resourceId = resourceId;
        if (this.list == null){
            this.list = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public BaseVMAdapter.VMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DB db = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), resourceId, parent, false);
        VMViewHolder holder = new VMViewHolder(db.getRoot());
        holder.bindView = db;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseVMAdapter.VMViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VMViewHolder extends RecyclerView.ViewHolder {

        public DB bindView;

        public VMViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}