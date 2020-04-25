package com.lutenglong.springcloud.eureka.order.interfaces;


import com.lutenglong.springcloud.eureka.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "service-user",fallback = UserFeignFallback.class)
public interface UserFeignClient {

    @RequestMapping("/user/list")
    public List<User> list();
}
