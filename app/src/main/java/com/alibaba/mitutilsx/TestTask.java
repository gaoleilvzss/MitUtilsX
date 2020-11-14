package com.alibaba.mitutilsx;

import com.alibaba.lib_utils.log.LogX;
import com.alibaba.lib_utils.thread.Task;

/**
 * create by 高 (｡◕‿◕｡) 磊
 * 2020/11/14
 * desc : test task
 */
public class TestTask extends Task {
    @Override
    protected void execute() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogX.d("test");
    }
}
