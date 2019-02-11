package com.f.mylibrary.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ActivityUtil {

    private static volatile ActivityUtil activityUtil;
    private static Application application;
    private static List<Activity> list = new ArrayList<>();

    private ActivityUtil() {
    }

    public static ActivityUtil getInstance() {
        if (activityUtil == null) {
            synchronized (ActivityUtil.class) {
                if (activityUtil == null) {
                    activityUtil = new ActivityUtil();
                }
            }
        }
        return activityUtil;
    }

    public static void initListener(Application mApplication){
        application = mApplication;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    addActivity(activity);
                }

                @Override
                public void onActivityStarted(Activity activity) {

                }

                @Override
                public void onActivityResumed(Activity activity) {

                }

                @Override
                public void onActivityPaused(Activity activity) {

                }

                @Override
                public void onActivityStopped(Activity activity) {

                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(Activity activity) {
                    if (null == list && list.isEmpty()) {
                        return;
                    }
                    if (list.contains(activity)) {
                        delActivity(activity);
                    }
                }
            });
        }
    }

    /**
     * 添加一个activity到管理
     */
    private static void addActivity(Activity activity) {
        list.add(activity);
    }

    /**
     * 删除一个activity在管理
     */
    private static void delActivity(Activity activity) {
        list.remove(activity);
    }

    /**
     * 获取当前Activity（栈中最后一个压入的）
     */
    public static Activity nowActivity() {
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(list.size() - 1);
        }
    }

    /**
     * 结束当前activity
     */
    public static void finishNowActivity() {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.get(list.size() - 1).finish();
    }

    /**
     * 结束指定类名的activity
     */
    public static void finishClassNameActivity(Class<?> cls) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Activity activity : list) {
            if (activity.getClass().equals(cls)) activity.finish();
        }
    }

    /**
     * 结束指定的activity
     */
    public static void finishActivity(Activity activity) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (activity != null) {
            list.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 根据类名返回activity
     */
    public static Activity findClassNameActivity(Class<?> cls) {
        Activity resultActivity = null;
        if (list != null) {
            for (Activity activity : list) {
                if (activity.getClass().equals(cls)) {
                    resultActivity = activity;
                    break;
                }
            }
        }
        return resultActivity;
    }

    /**
     * 获取当前activity名字
     */
    public static String getNowActivityName() {
        Activity activity = null;
        synchronized (list) {
            final int size = list.size() - 1;
            if (size < 0) {
                return null;
            }
            activity = list.get(size);
        }
        return activity.getClass().getName();
    }

    /**
     * 结束全部activity
     */
    public static void finishAllActivity() {
        if (list == null) {
            return;
        }
        for (Activity activity : list) {
            activity.finish();
        }
        list.clear();
    }

    /**
     * 退出应用程序
     */
    public static void appExit() {
        try {
            finishAllActivity();
        } catch (Exception e) {

        }
    }
}
