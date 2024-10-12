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

        // Este join de abajo es unicamente util si tu aplicacion no es una spring-boot-starter-web.
        // Ya que CompletableFuture por defecto usa ForkJoinPool y dicho creador de hilos crea hilos DEAMON
        // (que sean daemon implica que si el hilo principal termina se apaga la jvm y hace que los hilos daemon no se completen)

        // CompletableFuture<Void> cf1 = CompletableFuture.runAsync(notificationTask);
        // CompletableFuture<Void> cf2 = CompletableFuture.runAsync(packagingTask);
        // CompletableFuture<Void> allCf = CompletableFuture.allOf(cf1,cf2);
        // allCf.join();
    }

    public static void main(String[] args) {
        new CompletableFutureRunAsyncRunner().execute();
    }

}
