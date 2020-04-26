package com.lutenglong.springcloud.eureka.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lutenglong.springcloud.eureka.entity.NationVo;
import com.lutenglong.springcloud.eureka.entity.User;
import com.lutenglong.springcloud.eureka.user.mapper.UserMapper;
import com.lutenglong.springcloud.eureka.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TL-Lu
 * @since 2020-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<NationVo> cascader() {
        return userMapper.cascader();
    }
}
