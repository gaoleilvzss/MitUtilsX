package com.alibaba.lib_utils.thread;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * create by 高 (｡◕‿◕｡) 磊
 * 2020/11/14
 * desc :
 */
public class ThreadUtils {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    /**
     * 判断当前线程是否是️主线成
     *
     * @return
     */
    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /**
     * 获取主线程 Handler
     *
     * @return
     */
    public static Handler getMainHandler() {
        return HANDLER;
    }


    /**
     * 运行在主线程
     *
     * @param runnable
     */
    public static void runOnUiThread(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }


    /**
     * 延时运行在主线程
     *
     * @param runnable
     * @param delayMillis
     */
    public static void runOnUiThreadDelayed(final Runnable runnable, long delayMillis) {
        HANDLER.postDelayed(runnable, delayMillis);
    }


    //=======================================以下为线程池==============================================
    private static ExecutorService netWorkThread = Executors.newFixedThreadPool(4);//网络请求线程池
    private static ExecutorService imageOperate = Executors.newCachedThreadPool(); // 图片操作线程池
    private static ExecutorService dbThread = Executors.newCachedThreadPool();//数据库操作线程池

    public static void request(Task r) {
        netWorkThread.execute(r);
    }

    public static void getImageFeature(Task r) {
        imageOperate.execute(r);
    }

    public static void dataBaseOperate(Task r) {
        dbThread.execute(r);
    }

    public static void showDown() {
        netWorkThread.shutdown();
        imageOperate.shutdown();
        dbThread.shutdown();
    }
}
