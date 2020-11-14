package com.alibaba.mitutilsx;

import android.app.Application;

import com.alibaba.lib_utils.log.LogX;
import com.alibaba.lib_utils.log.LogXAdapter;

/**
 * create by 高 (｡◕‿◕｡) 磊
 * 2020/11/14
 * desc :
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogXAdapter adapter = new LogXAdapter.Builder()
                .setShowCurrentThread(true)
                .setShowLogSwitch(true)
                .setTag("winter")
                .build();
        LogX.addLogAdapter(adapter);
    }
}
