package com.dev.shopserver.config;



import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class SecurityConfig {
    /**
     * PasswordEncoder 를 Bean 으로 등록
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * CORS (Cross-Origin Resource Sharing)란?
     * 다른 출처(Origin)의 리소스를 가져와서 사용할 때 지켜야 할 정책이다.
     *
     * CORS 는 브라우저의 정책이기 때문에 서버에서 사용자의 요청을 처리하여
     * 브라우저를 사용하는 클라이언트에게 response 를 보내도 CORS 정책을 위반하면 브라우저에서 response 를 버리게 된다.
     *
     * disable()하면 Spring Security 의 CORS 기능을 끄는 것이기 때문에 실제 서비스 단계에서는 disable 하지 않고
     * CORS 설정을 해주어야 한다.
     *
     * 출처(Origin): Protocol, Host, PortNumber 를 모두 합친 것을 의미. 서버를 찾기 위해 가장 기본적인 정보
     * ----------------------------------------------------------------------------------
     * CSRF (Cross Site Request Forgery)
     * 웹 어플리케이션의 취약점 중 하나로 유저가 자신의 의지와는 상관없이 공격자가 의도한 행위를 요청하도록 만드는 공격이다.
     * 서버에서 토큰을 발급 및 검증하고 클라이언트에서 발급받은 토큰을 요청에 포함시켜 보내는 방식으로 방지할 수 있다.
     *
     * Spring Security 에서는 위와 같은 CSRF 방지 기능을 자동으로 추가하게 된다.
     * disable 하면 csrf 공격에 취약해지나, 초기 개발단계에서는 편의성을 위해 disable 을 한다.
     *
     *
     */
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()		// cors방지
                .csrf().disable()		// csrf방지
                .formLogin().disable()	// 기본 로그인 페이지 없애기
                .headers().frameOptions().disable();
        return http.build();
    }
}
