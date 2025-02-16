package com.example.tiendainn13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Tiendainn13Application {

	public static void main(String[] args) {
		SpringApplication.run(Tiendainn13Application.class, args);
	}

}
