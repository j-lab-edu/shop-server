package com.dev.shopserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//SpringBootApplication 동작 원리를
/**
 * SpringBootConfiguration,  @ComponentScan, @EnableAutoConfiguration 의 역할을 수행.
 *
 * ComponentScan은 @Component, @Configuration, @Service, @Controller, @RestController 등의 어노테이션을 스캔하여
 * 빈으로 등록.
 *
 * EnableAutoConfiguration은 사전에 정의한 라이브러리들을 빈으로 등록해주는 어노테이션.
 *
 */
@SpringBootApplication
public class ShopServerApplication{
	public static void main(String[] args) { SpringApplication.run(ShopServerApplication.class, args);
	}

}
