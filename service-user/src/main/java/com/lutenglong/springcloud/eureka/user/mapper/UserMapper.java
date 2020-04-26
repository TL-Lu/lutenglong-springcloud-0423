package com.lutenglong.springcloud.eureka.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lutenglong.springcloud.eureka.entity.NationVo;
import com.lutenglong.springcloud.eureka.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author TL-Lu
 * @since 2020-04-23
 */
public interface UserMapper extends BaseMapper<User> {

    List<NationVo> cascader();
}
