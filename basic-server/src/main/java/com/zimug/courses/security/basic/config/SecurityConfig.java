package com.zimug.courses.security.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        开启httpbasic认证
        http.httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
//                所有请求需要登录认证
                .authenticated();
//        httpBasic认证不安全 可以在网页对其进行解密
    }
}
