package com.alibaba.lib_utils.permission;

import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/**
 * create by 高 (｡◕‿◕｡) 磊
 * 2020/11/14
 * desc : 权限获取的工具类
 */
public class PermissionUtils {
    public static PermissionAdapter init(FragmentActivity activity) {
        return new PermissionAdapter(activity);
    }

    public static PermissionAdapter init(Fragment fragment) {
        return new PermissionAdapter(fragment);
    }

    public static boolean isGranted(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }
}
