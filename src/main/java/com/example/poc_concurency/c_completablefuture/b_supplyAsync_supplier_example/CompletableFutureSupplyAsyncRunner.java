package com.example.poc_concurency.c_completablefuture.b_supplyAsync_supplier_example;


import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class CompletableFutureSupplyAsyncRunner {

    public  void execute()  {
        NotificationService notificationService = new NotificationService();
        PackagingService packagingService = new PackagingService();

        // NotificationService will run in a thread asynchronously
        CompletableFuture<String> notificationFuture = CompletableFuture.supplyAsync(notificationService::execute);

        // PackagingService will run in a thread asynchronously
        CompletableFuture<String> packagingFuture = CompletableFuture.supplyAsync(packagingService::execute);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(notificationFuture, packagingFuture);

        allTasks.thenRun(() -> {
            try {
                //  En este punto la llamada a get() es no bloqueante thread-main
                String notificationResult = notificationFuture.get();
                String packagingResult = packagingFuture.get();
                System.out.println(notificationResult + ", "+  packagingResult);
            } catch (InterruptedException | ExecutionException e) {
            }
        });

        // Este join de abajo es unicamente util si tu aplicacion no es una spring-boot-starter-web.
        // Ya que CompletableFuture por defecto usa ForkJoinPool y dicho creador de hilos crea hilos DEAMON
        // (que sean daemon implica que si el hilo principal termina se apaga la jvm y hace que los hilos daemon no se completen)
        // allTasks.join();
    }

}
