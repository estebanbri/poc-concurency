package com.example.poc_concurency.a_thread.f_sincronizacion.a_visibilidad.volatile_example;


public class MyRunner {


    // Variable compartida y marcada como volatile
    public static  boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        long init = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "-thread start...");

        Runnable writerTask = new WriterTask();
        Runnable readerTask = new ReaderTask();

        Thread t1 = new Thread(writerTask);
        Thread t2 = new Thread(readerTask);
        t1.start();
        t2.start();

        long elapsedTime = System.currentTimeMillis() - init;

        System.out.println(Thread.currentThread().getName() + "-thread took " + elapsedTime + "(ms) to completes");


    }

}
