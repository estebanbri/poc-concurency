package com.example.poc_concurency.a_thread.problemas_concurrencia.a_visibilidad.volatile_example;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        long init = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "-thread start...");

        Runnable heavyTask = new HeavyTask();
        Runnable lightTask = new LightTask();

        Thread t1 = new Thread(heavyTask);
        Thread t2 = new Thread(lightTask);
        t1.start();
        t2.start();

        long elapsedTime = System.currentTimeMillis() - init;

        System.out.println(Thread.currentThread().getName() + "-thread took " + elapsedTime + "(ms) to completes");


    }

}
