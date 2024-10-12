package com.example.poc_concurency.d_spring_async.return_type_completablefuture_example;

import com.example.poc_concurency.util.ThreadUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class ResultPackagingService {

    @Async("taskExecutor")
    public CompletableFuture<String> execute() {
        System.out.println(Thread.currentThread().getName() + " start packaging task...");
        long millis = ThreadUtil.sleepTwoSecond();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete packaging task...");
        return CompletableFuture.completedFuture("RESULT_SUCCESS");
    }

}