package com.lutenglong.springcloud.eureka.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST","GET","PUT","OPPTIONS","DELETE")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(3600);
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("img/**").addResourceLocations("file:D:\\pic\\");
    }
}
