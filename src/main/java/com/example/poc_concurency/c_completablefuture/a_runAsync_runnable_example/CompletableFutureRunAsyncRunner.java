package com.example.poc_concurency.c_completablefuture.a_runAsync_runnable_example;

import com.example.poc_concurency.a_thread.a_basic_example.PackagingTask;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class CompletableFutureRunAsyncRunner {

    public void execute() {
        Runnable notificationTask = new NotificationTask();
        Runnable packagingTask = new PackagingTask();

        CompletableFuture.runAsync(notificationTask);
        CompletableFuture.runAsync(packagingTask);
    }

}
