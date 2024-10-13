package com.example.poc_concurency.d_spring_async.return_type_void_example;

import com.example.poc_concurency.thread_util.ThreadUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class VoidPackagingService {

    @Async
    public void execute() {
        System.out.println(Thread.currentThread().getName() + " start packaging task...");
        long millis = ThreadUtil.sleepTwoSecond();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete packaging task...");
    }

}