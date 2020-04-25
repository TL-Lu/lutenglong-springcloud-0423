package com.lutenglong.springcloud.eureka.order.interfaces;


import com.lutenglong.springcloud.eureka.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeignFallback implements UserFeignClient {

    @Override
    public List<User> list() {
        return null;
    }
}
