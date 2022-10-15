package com.mypetlikeit.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
      return web -> web.ignoring().antMatchers("/resources/**");
    }
  
    /*
     * web.ignoring() 은 Spring Security 가 해당 엔드포인트에 보안 헤더 또는 기타 보호 조치를 제공할 수
        없음을 의미한다. 따라서 authorizeHttpRequests permitAll 을 사용 할 경우 권한은 검증하지 않으면서
        요청을 보호 할수 있으므로 권장된다.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http.csrf().disable()
          .headers()
            .frameOptions().disable().and()
          .authorizeRequests()
            .antMatchers("/bootstrap/**/**").permitAll()
            .antMatchers("/login","/main","/", "/member","/signup").permitAll()
            .antMatchers("/user/**").hasRole("USER")
            .anyRequest().authenticated().and()
          .formLogin()
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/index").and()
          .logout()
            .logoutUrl("/logout").and()
          .build();
    }

    /*
     * resources(css, js 등) 의 경우 securityContext 등에 대한 조회가 불필요 하므로 disable 한다
     * @Order(0) 을 추가하여 먼저 FilterChain 을 타도록 지정한다
     */
    @Bean
    @Order(0)
    public SecurityFilterChain resources(HttpSecurity http) throws Exception {
      return http.requestMatchers(matchers -> matchers
              .antMatchers("/resources/**"))
          .authorizeHttpRequests(authorize -> authorize
              .anyRequest().permitAll())
          .requestCache(RequestCacheConfigurer::disable)
          .securityContext(AbstractHttpConfigurer::disable)
          .sessionManagement(AbstractHttpConfigurer::disable)
          .build();
    }
}
