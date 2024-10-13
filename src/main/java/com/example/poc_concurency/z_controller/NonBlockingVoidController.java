package com.example.poc_concurency.z_controller;

import com.example.poc_concurency.a_thread.a_basic_example.ThreadRunner;
import com.example.poc_concurency.b_executor_framework.a_execute_runnable_example.ExecutorRunnerRunnable;
import com.example.poc_concurency.b_executor_framework.b_submit_calleable_example.ExecutorRunnerCallable;
import com.example.poc_concurency.c_completablefuture.a_runAsync_runnable_example.CompletableFutureRunAsyncRunner;
import com.example.poc_concurency.c_completablefuture.b_supplyAsync_supplier_example.CompletableFutureSupplyAsyncRunner;
import com.example.poc_concurency.d_spring_async.return_type_completablefuture_example.AsyncExampleCompletableFutureRunner;
import com.example.poc_concurency.d_spring_async.return_type_void_example.AsyncExampleVoidRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/nonblocking-with-spring-async-void-example")
public class NonBlockingVoidController {
    @Autowired
    private ThreadRunner threadRunner;

    @Autowired
    private ExecutorRunnerRunnable executorRunnerRunnable;

    @Autowired
    private ExecutorRunnerCallable executorRunnerCalleable;

    @Autowired
    private CompletableFutureRunAsyncRunner completableFutureRunAsyncRunner;

    @Autowired
    private CompletableFutureSupplyAsyncRunner completableFutureSupplyAsyncRunner;

    @Autowired
    private AsyncExampleVoidRunner asyncExampleVoidRunner;

    @Autowired
    private AsyncExampleCompletableFutureRunner asyncExampleCompletableFutureRunner;


    @GetMapping
    public void execute() throws ExecutionException, InterruptedException {
        long init = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "-thread start...");

        // La request-thread al momento de toparse con este metodo @Async se livera la request-thread y retorna al pool y el control pasaria sobre el worker thread
        // threadRunner.execute();
        // executorRunnerRunnable.execute();
        // executorRunnerCalleable.execute(); // CASO CALLEABLE: UNICO CASO BLOQUEANTE AL THREAD INVOCADOR PADRE (EN ESTE CASO AL REQUEST_THREAD DE TOMCAT)
        // completableFutureRunAsyncRunner.execute();
        // completableFutureSupplyAsyncRunner.execute();
        asyncExampleVoidRunner.execute();
        //  asyncExampleCompletableFutureRunner.execute();

        long elapsedTime = System.currentTimeMillis() - init;

        System.out.println(Thread.currentThread().getName() + "-thread took " + elapsedTime + "(ms) to completes");
    }
}
