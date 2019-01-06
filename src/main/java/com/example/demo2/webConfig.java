package com.example.demo2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {
    exampleIntercepter exam = new exampleIntercepter();
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(exam).addPathPatterns("/");
    }
}
