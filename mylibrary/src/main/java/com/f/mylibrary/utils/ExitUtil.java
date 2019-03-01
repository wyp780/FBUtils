package com.f.mylibrary.utils;

import android.content.Context;

/**
 * 再按一次退出app
 */
public class ExitUtil {

    private static long time;

    public static void exit(Context mContext) {
        Context context = mContext.getApplicationContext();
        if (System.currentTimeMillis() - time > 2000) {
            ShowUtil.show("再按一次返回键退出");
            time = System.currentTimeMillis();
        } else {
            ActivityUtil.appExit();
        }
    }

}
