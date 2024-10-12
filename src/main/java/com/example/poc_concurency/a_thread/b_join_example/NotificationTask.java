package com.example.poc_concurency.a_thread.b_join_example;

import com.example.poc_concurency.util.ThreadUtil;

public class NotificationTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start notification task...");
        long millis = ThreadUtil.sleepFiveSeconds();
        System.out.println(Thread.currentThread().getName() + " thread took " + millis + "(ms) to complete notification task...");
    }

}
