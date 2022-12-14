package com.dev.shopserver.common.exception;

import lombok.extern.slf4j.Slf4j;
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

/*
 Slf4j는 로깅 프레임워크에 대한 인터페이스 역할을 하는 라이브러리.
 log4j2와 같은 로깅 관련 라이브러리는 점차 발전되어왔으며 추후에 로깅 라이브러리를
 교체할 이슈가 생길 경우 코드는 바꾸지 않은 채 로깅 라이브러리만 변경하면 된다.
 */
@Slf4j
@RestControllerAdvice
public class ShopServerExceptionHandler {


    @ExceptionHandler(value = ShopServerException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(ShopServerException e){
        HttpHeaders responseHeaders = new HttpHeaders();

        Map<String, String> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("error code", Integer.toString(e.getHttpStatusCode()));
        map.put("message", e.getMessage());
        log.info(e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
    }
}
