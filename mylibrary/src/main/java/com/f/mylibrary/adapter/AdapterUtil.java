package com.f.mylibrary.adapter;


import android.databinding.ViewDataBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAC on 2018/5/14.
 */

public class AdapterUtil {

    public static int[] resId(int... i) {
        return i;
    }

    public static List<ViewDataBinding> bindingList(ViewDataBinding... binding) {
        List<ViewDataBinding> list = new ArrayList<>();
        for (ViewDataBinding viewDataBinding : binding) {
            list.add(viewDataBinding);
        }
        return list;
    }

}
