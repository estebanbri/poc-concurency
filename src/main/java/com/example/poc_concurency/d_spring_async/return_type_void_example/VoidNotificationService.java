package com.example.poc_concurency.d_spring_async.return_type_void_example;

import com.example.poc_concurency.thread_util.ThreadUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class VoidNotificationService {
    @Async
    public void execute() {
        System.out.println(Thread.currentThread().getName() + " start notification task...");
        long millis = ThreadUtil.sleepFiveSeconds();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete notification task...");
    }
}

