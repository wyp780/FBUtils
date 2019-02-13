package com.f.mylibrary.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * apk版本号 和 版本名
 */
public class APKVersionCodeUtil {

    public static int getVersionCode(Context mContext) {
        Context context = mContext.getApplicationContext();
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    public static String getVersionName(Context mContext) {
        Context context = mContext.getApplicationContext();
        String versionName = "";
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

}
