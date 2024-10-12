package com.example.poc_concurency.a_thread.b_join_example;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long init = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "-thread start...");

        Runnable notificationTask = new NotificationTask();
        Runnable packagingTask = new PackagingTask();

        Thread t1 = new Thread(notificationTask);
        Thread t2 = new Thread(packagingTask);

        t1.start();
        t2.start();

        t1.join(); // Blocks main-thread execution til t1 completes
        t2.join(); // Blocks main-thread execution til t2 completes

        long elapsedTime = System.currentTimeMillis() - init;

        System.out.println(Thread.currentThread().getName() + "-thread took " + elapsedTime + "(ms) to completes");


    }

}
