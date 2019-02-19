package com.f.mylibrary.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public abstract class BaseMultipleAdapter<T> extends BaseAonlyAdapter<T> {

    public BaseMultipleAdapter(Context context, int[] layoutId, List<ViewDataBinding> itemBinding) {
        super(context, layoutId, itemBinding);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, T t, int position) {
        if(getItemViewType(position) != 999){
            onBinds(viewHolder, t, position, getItemViewType(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(getList().size() == 0){
            return 999;
        }
        return getItemType(position);
    }

    public abstract int getItemType(int position);

    public abstract void onBinds(RecyclerView.ViewHolder holder, T t, int position, int itemType);
}
