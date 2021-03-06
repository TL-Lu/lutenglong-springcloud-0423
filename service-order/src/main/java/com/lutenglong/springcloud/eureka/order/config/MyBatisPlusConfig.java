package com.lutenglong.springcloud.eureka.order.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lutenglong.springcloud.eureka.order.mapper")
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor page() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

}