package com.example.poc_concurency.a_thread.problemas_concurrencia.a_visibilidad.volatile_example;

import com.example.poc_concurency.thread_util.ThreadUtil;

public class HeavyTask implements Runnable {

    @Override
    public void run() {
        final int length = 6;
        for (int i = 0; i < 5; i++) {
            long millis = ThreadUtil.sleepFiveSeconds();
            System.out.println(Thread.currentThread().getName() + " thread took " + millis + "(ms) to complete heavy task...");
            // Suggest to yield the processor to another thread of the same priority
            if (i == length / 2 ) { // Cuando llegue a la mitad del procesamiento ceder uso de cpu
                System.out.println(Thread.currentThread().getName() + " ha cedido el uso del cpu...");
                Thread.yield();
            }
        }
    }

}
