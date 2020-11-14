package com.alibaba.lib_utils.permission;

import java.util.List;

/**
 * create by 高 (｡◕‿◕｡) 磊
 * 2020/11/14
 * desc : 权限获取的回调
 */
public interface PermissionCallBack {
    void onResult(boolean allGranted, List<String> grantedList, List<String> deniedList);
}
