package com.alibaba.lib_utils.log;

/**
 * log adapter
 */
public class LogXAdapter {
    private String globalTag = "winter";
    private boolean isShowSwitch = false;
    private boolean showCurrentThreadName = false;


    public LogXAdapter(Builder builder) {
        this.globalTag = builder.tag;
        this.isShowSwitch = builder.showLogSwitch;
        this.showCurrentThreadName = builder.showCurrentThreadName;
    }

    public boolean isShowCurrentThreadName() {
        return showCurrentThreadName;
    }

    public String getGlobalTag() {
        return globalTag;
    }

    public boolean isShowSwitch() {
        return isShowSwitch;
    }

    public static class Builder {
        private String tag;
        private boolean showLogSwitch;
        private boolean showCurrentThreadName;

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder setShowCurrentThread(boolean showCurrentThread) {
            this.showCurrentThreadName = showCurrentThread;
            return this;
        }

        public Builder setShowLogSwitch(boolean isShowLog) {
            this.showLogSwitch = isShowLog;
            return this;
        }

        public LogXAdapter build() {
            return new LogXAdapter(this);
        }
    }
}
