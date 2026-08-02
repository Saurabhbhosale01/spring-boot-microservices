package com.product_service.controller;

import com.product_service.response.Response;
import com.product_service.response.ResponseCode;
import com.product_service.service.messageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


public class appController {

    @Autowired
    private  messageService messageService;

    @Autowired
    private  HttpServletRequest httpServletRequest;

    public ResponseEntity<Response> data(Object entity) {
        return data(ResponseCode.ENTITY, null, entity);
    }

    public ResponseEntity<Response> data(ResponseCode code , String message, Object entity){
        return new ResponseEntity<>(Response.builder()
                .code(code)
                .message(message)
                .data(entity)
                .path(httpServletRequest.getRequestURI())
                .requestId(UUID.randomUUID().toString())
                .build(), HttpStatus.OK);
    }

    public ResponseEntity<Response> success(ResponseCode code, String... fields){
        return new ResponseEntity<>(Response.builder()
                .code(code)
                .message(messageService.getMessage(code,fields))
                .path(httpServletRequest.getRequestURI())
                .requestId(UUID.randomUUID().toString())
                .build(), HttpStatus.OK);
    }
}
