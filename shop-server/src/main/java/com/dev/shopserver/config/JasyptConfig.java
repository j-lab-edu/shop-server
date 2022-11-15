package com.dev.shopserver.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Jasypt Doc http://www.jasypt.org/javadoc.html
 * 암호화 작동 방식을 잘 알지 못해도 쉽게 사용 가능한 암호화 라이브러리
 * Spring 기반 어플리케이션과 통합에 적합하여 사용.
 */
@Configuration
public class JasyptConfig {


    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("dev_Key"); // 암호화 키 값
        config.setPoolSize("1");
        encryptor.setConfig(config);
        return encryptor;
    }
}

