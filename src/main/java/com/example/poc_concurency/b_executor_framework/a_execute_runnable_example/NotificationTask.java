package com.example.poc_concurency.b_executor_framework.a_execute_runnable_example;

import com.example.poc_concurency.thread_util.ThreadUtil;

public class NotificationTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start notification task...");
        long millis = ThreadUtil.sleepFiveSeconds();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete notification task...");
    }
}

