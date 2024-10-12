package com.example.poc_concurency;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class PocConcurencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocConcurencyApplication.class, args);
	}

	@Bean(name = "taskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);        // Número de hilos mínimo
		executor.setMaxPoolSize(5);         // Número de hilos máximo
		executor.setQueueCapacity(500);     // Capacidad de la cola
		executor.setThreadNamePrefix("Async-");
		executor.initialize();
		return executor;
	}
}
