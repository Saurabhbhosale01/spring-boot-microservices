package com.product_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = ("Product service Api"),description=("API documentation for  Product service"),version = ("1.1")))
public class ProductServiceApplication {

	public static void main(String[] args) {


        SpringApplication.run(ProductServiceApplication.class, args);
	}

}
