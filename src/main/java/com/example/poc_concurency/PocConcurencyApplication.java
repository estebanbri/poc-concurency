package com.example.poc_concurency;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class PocConcurencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocConcurencyApplication.class, args);
	}

}
