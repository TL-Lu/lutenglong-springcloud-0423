package com.lutenglong.springcloud.eureka.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lutenglong.springcloud.eureka.entity.NationVo;
import com.lutenglong.springcloud.eureka.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author TL-Lu
 * @since 2020-04-23
 */
public interface IUserService extends IService<User> {

    List<NationVo> cascader();
}
