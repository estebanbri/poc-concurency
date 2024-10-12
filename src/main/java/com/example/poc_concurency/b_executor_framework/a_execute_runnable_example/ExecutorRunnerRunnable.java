package com.example.poc_concurency.b_executor_framework.a_execute_runnable_example;

import com.example.poc_concurency.a_thread.a_basic_example.PackagingTask;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ExecutorRunnerRunnable {

    public void execute() {
        Runnable notificationTask = new NotificationTask();
        Runnable packagingTask = new PackagingTask();

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(notificationTask);
        executor.execute(packagingTask);

        executor.shutdown();
    }

}
