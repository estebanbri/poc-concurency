package com.example.poc_concurency.c_completablefuture.b_supplyAsync_supplier_example;

import com.example.poc_concurency.util.ThreadUtil;

import java.util.concurrent.Callable;

public class PackagingService {

    public String execute() {
        System.out.println(Thread.currentThread().getName() + " start packaging task...");
        long millis = ThreadUtil.sleepTwoSecond();
        System.out.println(Thread.currentThread().getName() + " took " + millis + "(ms) to complete packaging task...");
        return "RESULT_SUCCESS";
    }

}