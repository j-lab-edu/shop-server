package com.dev.shopserver.config;



import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {
    /**
     * PasswordEncoder를 Bean으로 등록
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 인증 or 인가에 대한 설정
     */
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()		//cors방지
                .csrf().disable()		//csrf방지
                .formLogin().disable()	//기본 로그인 페이지 없애기
                .headers().frameOptions().disable();
        return http.build();
    }
}