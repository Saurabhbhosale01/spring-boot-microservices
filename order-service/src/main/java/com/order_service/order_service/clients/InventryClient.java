package com.order_service.order_service.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventry", url = "http://localhost:8082")
public interface InventryClient {

    @RequestMapping(method= RequestMethod.GET ,value = "api/master/inventry")
    boolean inStock(@RequestParam String skuCode , @RequestParam Integer quantity);

}
