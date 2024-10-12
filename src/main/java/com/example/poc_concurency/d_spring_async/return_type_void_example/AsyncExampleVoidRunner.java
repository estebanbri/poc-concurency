package com.example.poc_concurency.d_spring_async.return_type_void_example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AsyncExampleVoidRunner {

    @Autowired
    private VoidNotificationService notificationService;

    @Autowired
    private VoidPackagingService packagingService;

    public  void execute() {
        // will run in a thread asynchronously
        notificationService.execute();
        packagingService.execute();
    }

}
