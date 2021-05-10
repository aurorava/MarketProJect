package com.cl.boot.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 处理跨域
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").
//                allowedOrigins("http://127.0.0.1:443",null).
//                allowedMethods("POST","GET","PUT","HEAD","OPTIONS","DELETE").
//                allowCredentials(true).
//                maxAge(3600);
//
//    }
}
