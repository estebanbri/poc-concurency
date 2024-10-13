package com.example.poc_concurency.a_thread.problemas_concurrencia.a_visibilidad.volatile_example;

import com.example.poc_concurency.thread_util.ThreadUtil;

public class LightTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long millis = ThreadUtil.sleepTwoSecond();
            System.out.println(Thread.currentThread().getName() + " thread took " + millis + "(ms) to complete light task...");
        }
    }

}