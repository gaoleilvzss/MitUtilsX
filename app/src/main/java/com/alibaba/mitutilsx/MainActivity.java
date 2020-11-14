package com.alibaba.mitutilsx;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;

import com.alibaba.lib_utils.log.LogX;
import com.alibaba.lib_utils.permission.PermissionUtils;
import com.alibaba.lib_utils.thread.ThreadUtils;


/**
 * create by 高 (｡◕‿◕｡) 磊
 * 2020/11/14
 * desc : test activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionUtils.init(this).permission(Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.CAMERA
                , Manifest.permission.CALL_PHONE)
                .request((allGranted, grantedList, deniedList) -> {
                    LogX.e(String.valueOf(allGranted));
                    for (String s : grantedList) {
                        LogX.e(s);
                    }
                    for (String s : deniedList) {
                        LogX.e(s);
                    }
                });

        ThreadUtils.request(new TestTask());

    }
}