package com.example.friendship.config;

import com.example.friendship.interceptor.LoginCheckInterceptor;
import com.example.friendship.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry){

       // registry.addInterceptor(new loginInterceptor())
         //       .order(1)
           //     .addPathPatterns("/**")
             //   .excludePathPatterns("/css/**", "/*.ico", "/error");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("")
                .excludePathPatterns(  "/","/join", "/login", "/logout", "loginPro" ,
                        "/css/***", "/*.ico", "/error");
    }
}