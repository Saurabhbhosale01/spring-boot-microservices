package com.order_service.order_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI orderServiceSwagger(){
        return new OpenAPI()
                .info(new Info()
                        .title("Order service")
                        .version("1.1")
                        .description("API documentation for  Product service"));
    }
}
