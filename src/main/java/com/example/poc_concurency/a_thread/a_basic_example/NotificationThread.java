package com.example.poc_concurency.a_thread.a_basic_example;

import com.example.poc_concurency.util.ThreadUtil;

public class NotificationThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start notification task...");
        long millis = ThreadUtil.sleepFiveSeconds();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete notification task...");
    }
}
