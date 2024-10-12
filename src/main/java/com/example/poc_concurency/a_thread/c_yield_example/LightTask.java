package com.example.poc_concurency.a_thread.c_yield_example;

import com.example.poc_concurency.util.ThreadUtil;

public class LightTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long millis = ThreadUtil.sleepTwoSecond();
            System.out.println(Thread.currentThread().getName() + " thread took " + millis + "(ms) to complete light task...");
        }
    }

}