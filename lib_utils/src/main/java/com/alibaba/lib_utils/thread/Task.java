package com.alibaba.lib_utils.thread;

public abstract class Task implements Runnable{

    @Override
    public void run() {
        execute();
    }

    protected abstract void execute();
}
