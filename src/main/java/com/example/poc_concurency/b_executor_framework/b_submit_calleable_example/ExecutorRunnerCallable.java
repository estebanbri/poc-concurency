package com.example.poc_concurency.b_executor_framework.b_submit_calleable_example;


import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class ExecutorRunnerCallable {

    public void execute() throws InterruptedException, ExecutionException {

        Callable<String> notificationCallable = new NotificationCalleable();
        Callable<String> packagingCallable = new PackagingCalleable();

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<String> notificationFuture = executor.submit(notificationCallable);
        Future<String> packagingFuture = executor.submit(packagingCallable);

        executor.shutdown();  // No acepta nuevas tareas, pero espera a que las actuales terminen pero no bloquea al hilo principal

        // Bloquea el hilo principal hasta que todas las tareas finalicen si en 6 segundos no finalizacion todas arroja un timeout
        if (!executor.awaitTermination(6, TimeUnit.SECONDS)) {
            System.out.println("Timeout: Some tasks did not finish in time.");
        } else {
            //  En este punto la llamada a get() es no bloqueante porque awaitTermination es quien ya bloqueo a thread-main hasta que se resuelvan todas las tareas
            String notificationResult = notificationFuture.get();
            String packagingResult = packagingFuture.get();

            System.out.println(notificationResult + ", "+  packagingResult);
        }
    }

}
