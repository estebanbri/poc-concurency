package com.example.poc_concurency.z_controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/nonblocking-request-thread-with-async-processing")
public class NonBlockingRequestThreadController {
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
