package com.dev.shopserver.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
RestControllerAdvice는 ResponseBody와 ControllerAdvice를 합친 어노테이션.
ControllerAdvice는 모든 Controller에 대한 전역적으로 발생하는 예외를 잡아서 처리해줌.
그리고 ReponseBody가 합쳐진 어노테이션이기 때문에 객체를 리턴할 수 있다.
에러 메세지를 DTO객체에 담아 리턴해주는 방식으로 사용.


 */
@RestControllerAdvice
public class ShopServerExceptionHandler {


    @ExceptionHandler(value = ShopServerException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(ShopServerException e){
        HttpHeaders responseHeaders = new HttpHeaders();

        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("error code", Integer.toString(e.getHttpStatusCode()));
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
    }
}
