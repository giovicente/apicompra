package com.mastertech.itau.cambio.ApiCompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCompraApplication.class, args);
	}

}
