package com.f.fbutils;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.f.fbutils.databinding.Item1Binding;
import com.f.mylibrary.adapter.BaseAonlyAdapter;
import com.f.mylibrary.adapter.BaseMultipleAdapter;

import java.util.List;

public class TestAdapter extends BaseMultipleAdapter<String> {

    public TestAdapter(Context context, int[] layoutId, List<ViewDataBinding> itemBinding) {
        super(context, layoutId, itemBinding);
    }

    @Override
    public int getItemType(int position) {
        if ((position % 2) == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public void onBinds(RecyclerView.ViewHolder holder, String s, int position, int itemType) {
        Item1Binding binding = DataBindingUtil.getBinding(holder.itemView);
    }
}
