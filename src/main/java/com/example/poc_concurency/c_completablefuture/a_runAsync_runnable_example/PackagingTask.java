package com.example.poc_concurency.c_completablefuture.a_runAsync_runnable_example;

import com.example.poc_concurency.thread_util.ThreadUtil;

public class PackagingTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start packaging task...");
        long millis = ThreadUtil.sleepTwoSecond();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete packaging task...");
    }

}