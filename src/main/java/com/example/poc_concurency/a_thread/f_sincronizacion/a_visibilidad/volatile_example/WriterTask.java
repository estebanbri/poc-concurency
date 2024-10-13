package com.example.poc_concurency.a_thread.f_sincronizacion.a_visibilidad.volatile_example;

import com.example.poc_concurency.thread_util.ThreadUtil;

public class WriterTask implements Runnable {

    @Override
    public void run() {
        ThreadUtil.sleepTwoSecond();
        System.out.println(Thread.currentThread().getName() + " - Writer Thread will shutdown...");
        // Cambiamos el valor del flag a false
        MyRunner.running = false;
    }

}
