package com.alibaba.lib_utils.permission;

import java.util.List;

public interface PermissionCallBack {
    void onResult(boolean allGranted, List<String> grantedList, List<String> deniedList);
}
