package com.example.poc_concurency.controller;

import com.example.poc_concurency.a_thread.a_basic_example.ThreadRunner;
import com.example.poc_concurency.b_executor_framework.a_execute_runnable_example.ExecutorRunnerRunnable;
import com.example.poc_concurency.b_executor_framework.b_submit_calleable_example.ExecutorRunnerCallable;
import com.example.poc_concurency.c_completablefuture.a_runAsync_runnable_example.CompletableFutureRunAsyncRunner;
import com.example.poc_concurency.c_completablefuture.b_supplyAsync_supplier_example.CompletableFutureSupplyAsyncRunner;
import com.example.poc_concurency.d_spring_async.return_type_completablefuture_example.AsyncExampleCompletableFutureRunner;
import com.example.poc_concurency.d_spring_async.return_type_void_example.AsyncExampleVoidRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/blocking")
public class BlockingRequestThreadController {
    @Autowired
    private FileProcessorService fileProcessorService;

    @GetMapping
    public CompletableFuture<String> execute() throws ExecutionException, InterruptedException {
        return fileProcessorService.getTextAsync();
    }
}

@Component
class FileProcessorService {
    @Async  // La request al momento de toparse con este metodo @Async liberara el request-thread y lo devolvera al pool y el control pasaria sobre el worker thread
    CompletableFuture<String> getTextAsync () {
        String text = parseFileAndGetText();
        return CompletableFuture.completedFuture(text);
    }

    private String parseFileAndGetText() {
        // Procesamiento heavy
        return "text";
    }
}
