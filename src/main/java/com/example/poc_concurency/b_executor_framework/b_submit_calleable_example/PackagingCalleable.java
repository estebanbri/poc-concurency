package com.example.poc_concurency.b_executor_framework.b_submit_calleable_example;

import com.example.poc_concurency.thread_util.ThreadUtil;

import java.util.concurrent.Callable;

public class PackagingCalleable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " start packaging task...");
        long millis = ThreadUtil.sleepTwoSecond();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete packaging task...");
        return "RESULT_SUCCESS";
    }

}