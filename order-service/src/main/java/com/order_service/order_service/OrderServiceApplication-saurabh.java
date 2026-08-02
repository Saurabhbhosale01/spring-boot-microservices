package com.order_service.order_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.sound.sampled.Line;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = ("Order Service"),description=("order-service from Ecommerce web"), version = ("1.1")))
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
