package com.example.poc_concurency.a_thread.a_basic_example;

import org.springframework.stereotype.Component;

@Component
public class ThreadRunner {

    public  void execute() {
        // Opcion 1
        Thread t1 = new NotificationThread();

        // Opcion 2
        Runnable task = new PackagingTask();
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }

}

