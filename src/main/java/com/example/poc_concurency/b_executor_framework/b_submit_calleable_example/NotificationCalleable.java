package com.example.poc_concurency.b_executor_framework.b_submit_calleable_example;

import com.example.poc_concurency.util.ThreadUtil;

import java.util.concurrent.Callable;

public class NotificationCalleable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " start notification task...");
        long millis = ThreadUtil.sleepFiveSeconds();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete notification task...");
        return "RESULT_SUCCESS";
    }
}

