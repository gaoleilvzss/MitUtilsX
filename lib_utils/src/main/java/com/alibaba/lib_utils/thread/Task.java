package com.alibaba.lib_utils.thread;

/**
 * create by 高 (｡◕‿◕｡) 磊
 * 2020/11/14
 * desc : 线程池的任务的基类
 */
public abstract class Task implements Runnable{

    @Override
    public void run() {
        execute();
    }

    protected abstract void execute();
}
