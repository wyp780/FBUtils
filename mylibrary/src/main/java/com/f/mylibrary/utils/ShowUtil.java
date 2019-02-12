package com.f.mylibrary.utils;

import android.view.Gravity;
import android.widget.Toast;

public class ShowUtil {

    public static void show(String s) {
        Toast toast = Toast.makeText(ActivityUtil.nowActivity(), s, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
