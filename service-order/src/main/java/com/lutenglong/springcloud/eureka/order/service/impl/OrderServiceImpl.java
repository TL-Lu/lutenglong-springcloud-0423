package com.lutenglong.springcloud.eureka.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lutenglong.springcloud.eureka.entity.Order;
import com.lutenglong.springcloud.eureka.order.mapper.OrderMapper;
import com.lutenglong.springcloud.eureka.order.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TL-Lu
 * @since 2020-04-23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
