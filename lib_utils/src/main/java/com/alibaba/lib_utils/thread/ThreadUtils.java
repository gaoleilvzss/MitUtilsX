package com.alibaba.lib_utils.thread;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static Handler getMainHandler() {
        return HANDLER;
    }


    public static void runOnUiThread(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }


    public static void runOnUiThreadDelayed(final Runnable runnable, long delayMillis) {
        HANDLER.postDelayed(runnable, delayMillis);
    }


    //=======================================executor==============================================
    private static ExecutorService netWorkThread = Executors.newFixedThreadPool(4);
    private static ExecutorService imageOperate = Executors.newCachedThreadPool();
    private static ExecutorService dbThread = Executors.newCachedThreadPool();

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
