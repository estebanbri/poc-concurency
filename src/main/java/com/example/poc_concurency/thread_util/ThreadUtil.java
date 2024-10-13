package com.example.poc_concurency.thread_util;

public class ThreadUtil {
    private static final long TWO_SECOND = 2000L;
    private static final long FIVE_SECONDS = 5000L;

    public static long sleepTwoSecond() {
        return sleep(TWO_SECOND);
    }

    public static long sleepFiveSeconds() {
        return sleep(FIVE_SECONDS);
    }
    public static long sleep(long millis) {
        try {
            Thread.sleep(millis);
            return millis;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
