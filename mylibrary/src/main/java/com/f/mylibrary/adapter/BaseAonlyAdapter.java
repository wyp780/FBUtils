package com.f.mylibrary.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.f.mylibrary.R;
import com.f.mylibrary.databinding.NoDataBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class BaseAonlyAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int[] layoutId;
    private List<ViewDataBinding> itemBinding = new ArrayList<>();
    private ObservableArrayList<T> list = new ObservableArrayList<>();
    protected ListChangedCallback itemsChangeCallback;
    public boolean showNoData = false;

    public BaseAonlyAdapter(Context context, int[] layoutId, List<ViewDataBinding> itemBinding) {
        this.context = context;
        this.layoutId = layoutId;
        this.itemBinding = itemBinding;

        itemsChangeCallback = new ListChangedCallback();
    }

    public void setList(List<T> list) {
        this.list.clear();
        this.list.addAll(list);
    }

    public void addList(List<T> list) {
        this.list.addAll(list);
    }

    public List<T> getList() {
        return list;
    }

    public void setShowNoData(boolean b) {
        this.showNoData = b;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 999) {
            View emptyView = LayoutInflater.from(context).inflate(R.layout.no_data, viewGroup, false);
            return new BaseViewHolder(emptyView);
        }
        BaseViewHolder viewHolder;
        ViewDataBinding binding = itemBinding.get(getItemViewType(i));
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId[getItemViewType(i)],
                viewGroup, false);
        viewHolder = new BaseViewHolder(binding.getRoot());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) != 999) {
            onBind(viewHolder, list.get(i), i);
        }
    }

    public abstract void onBind(RecyclerView.ViewHolder viewHolder, T t, int position);

    @Override
    public int getItemCount() {
        if (list.size() == 0 && showNoData) {
            return 1;
        }
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.size() == 0 && showNoData) {
            return 999;
        }
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.list.addOnListChangedCallback(itemsChangeCallback);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.list.removeOnListChangedCallback(itemsChangeCallback);
    }

    class ListChangedCallback extends ObservableArrayList.OnListChangedCallback<ObservableArrayList<T>> {
        @Override
        public void onChanged(ObservableArrayList<T> newItems) {
            BaseAonlyAdapter.this.onChanged(newItems);
        }

        @Override
        public void onItemRangeChanged(ObservableArrayList<T> newItems, int i, int i1) {
            BaseAonlyAdapter.this.onItemRangeChanged(newItems, i, i1);
        }

        @Override
        public void onItemRangeInserted(ObservableArrayList<T> newItems, int i, int i1) {
            BaseAonlyAdapter.this.onItemRangeInserted(newItems, i, i1);
        }

        @Override
        public void onItemRangeMoved(ObservableArrayList<T> newItems, int i, int i1, int i2) {
            BaseAonlyAdapter.this.onItemRangeMoved(newItems);
        }

        @Override
        public void onItemRangeRemoved(ObservableArrayList<T> sender, int positionStart, int itemCount) {
            BaseAonlyAdapter.this.onItemRangeRemoved(sender, positionStart, itemCount);
        }
    }

    //region 处理数据集变化
    protected void onChanged(ObservableArrayList<T> newItems) {
        resetItems(newItems);
        notifyDataSetChanged();
    }

    protected void onItemRangeChanged(ObservableArrayList<T> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeChanged(positionStart, itemCount);
    }

    protected void onItemRangeInserted(ObservableArrayList<T> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeInserted(positionStart, itemCount);
    }

    protected void onItemRangeMoved(ObservableArrayList<T> newItems) {
        resetItems(newItems);
        notifyDataSetChanged();
    }

    protected void onItemRangeRemoved(ObservableArrayList<T> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    protected void resetItems(ObservableArrayList<T> newItems) {
        this.list = newItems;
    }
}
