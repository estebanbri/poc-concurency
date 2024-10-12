package com.example.poc_concurency.c_completablefuture.b_supplyAsync_supplier_example;

import com.example.poc_concurency.util.ThreadUtil;

import java.util.concurrent.Callable;

public class NotificationService {
    public String execute() {
        System.out.println(Thread.currentThread().getName() + " start notification task...");
        long millis = ThreadUtil.sleepFiveSeconds();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete notification task...");
        return "RESULT_SUCCESS";
    }
}

