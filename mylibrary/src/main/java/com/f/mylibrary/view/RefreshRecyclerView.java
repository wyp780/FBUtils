package com.f.mylibrary.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.f.mylibrary.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

public class RefreshRecyclerView extends RelativeLayout {

    private RecyclerView recyclerView;
    private SmartRefreshLayout smartRefreshLayout;

    public RefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        View inflate = inflate(getContext(), R.layout.refresh_recyclerview, this);

        smartRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.smartrefreshlayout);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerview1);

        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(context));
    }

    public SmartRefreshLayout getSmartRefreshLayout() {
        return smartRefreshLayout;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }


}
