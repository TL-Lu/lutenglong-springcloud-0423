package com.lutenglong.springcloud.eureka.order.controller;


import com.lutenglong.springcloud.eureka.entity.Order;
import com.lutenglong.springcloud.eureka.entity.User;
import com.lutenglong.springcloud.eureka.order.interfaces.UserFeignClient;
import com.lutenglong.springcloud.eureka.order.service.IOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author TL-Lu
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService iOrderService;

    @Autowired
    UserFeignClient userFeignClient;

    @RequestMapping("list")
    public List<Order> list(Integer id){
        return  iOrderService.list();
    }

    @RequestMapping("userList")
    @HystrixCommand(fallbackMethod = "userListFallback")
    public List<User> userList(){
        return  userFeignClient.list();
    }

    public List<User> userListFallback(){
        return  null;
    }
}

