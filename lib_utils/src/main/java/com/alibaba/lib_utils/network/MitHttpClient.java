package com.alibaba.lib_utils.network;


import java.util.concurrent.TimeUnit;


/**
 * create by 高 (｡◕‿◕｡) 磊
 * 2020/11/15
 * desc :
 */
public class MitHttpClient {

    final int connectTimeout;
    final int readTimeout;
    final int writeTimeout;

    public MitHttpClient() {
        this(new Builder());
    }

    MitHttpClient(Builder builder) {
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
    }

    public static final class Builder {
        int connectTimeout;
        int readTimeout;
        int writeTimeout;
        public Builder() {
            connectTimeout = 10_000;
            readTimeout = 10_000;
            writeTimeout = 10_000;
        }

        public Builder connectTimeout(long timeout, TimeUnit unit) {
            connectTimeout = checkDuration("timeout", timeout, unit);
            return this;
        }

        public Builder readTimeout(long timeout, TimeUnit unit) {
            readTimeout = checkDuration("timeout", timeout, unit);
            return this;
        }

        public Builder writeTimeout(long timeout, TimeUnit unit) {
            writeTimeout = checkDuration("timeout", timeout, unit);
            return this;
        }

        public MitHttpClient build() {
            return new MitHttpClient(this);
        }
    }

    private static int checkDuration(String name, long duration, TimeUnit unit) {
        if (duration < 0) throw new IllegalArgumentException(name + " < 0");
        if (unit == null) throw new NullPointerException("unit == null");
        long millis = unit.toMillis(duration);
        if (millis > Integer.MAX_VALUE) throw new IllegalArgumentException(name + " too large.");
        if (millis == 0 && duration > 0) throw new IllegalArgumentException(name + " too small.");
        return (int) millis;
    }
}
