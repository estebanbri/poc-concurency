package com.example.poc_concurency.a_thread.a_basic_example;

import com.example.poc_concurency.util.ThreadUtil;

public class PackagingTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start packaging task...");
        long millis = ThreadUtil.sleepTwoSecond();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete packaging task...");
    }

}
