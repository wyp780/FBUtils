package com.f.fbutils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.f.fbutils.databinding.Item1Binding;
import com.f.fbutils.databinding.Item2Binding;
import com.f.mylibrary.adapter.AdapterUtil;
import com.f.mylibrary.view.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TestClass extends Activity {

    private RefreshRecyclerView refreshRecyclerView;
    private TestAdapter adapter;
    private Item1Binding item1Binding;
    private Item2Binding item2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        refreshRecyclerView = (RefreshRecyclerView) findViewById(R.id.recyclerview);//带刷新的recyclerview
        refreshRecyclerView.getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        adapter = new TestAdapter(this, AdapterUtil.resId(R.layout.item1, R.layout.item2),
                AdapterUtil.bindingList(item1Binding, item2Binding));//item布局
        refreshRecyclerView.getRecyclerView().setAdapter(adapter);
        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            list.add("");
//        }
        adapter.setList(list);

        //要是不想要刷新
        refreshRecyclerView.getSmartRefreshLayout().setEnableRefresh(false);
        refreshRecyclerView.getSmartRefreshLayout().setEnableLoadMore(false);
    }
}
