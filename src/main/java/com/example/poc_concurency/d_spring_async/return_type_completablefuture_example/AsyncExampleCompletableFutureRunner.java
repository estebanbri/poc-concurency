package com.example.poc_concurency.d_spring_async.return_type_completablefuture_example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class AsyncExampleCompletableFutureRunner {

    @Autowired
    private ResultNotificationService notificationService;
    @Autowired
    private ResultPackagingService packagingService;

    public void execute() throws ExecutionException, InterruptedException {
        CompletableFuture<String> notificationFuture = notificationService.execute();
        CompletableFuture<String> packagingFuture = packagingService.execute();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(notificationFuture, packagingFuture);

        allOf.thenRun(() -> {
            try {
                String notificationResult = notificationFuture.get();
                String packagingResult = packagingFuture.get();
                System.out.println(notificationResult + ", " + packagingResult);
            } catch (InterruptedException | ExecutionException e) {
            }
        });
    }

}
