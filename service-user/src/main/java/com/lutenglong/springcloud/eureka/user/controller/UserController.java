package com.lutenglong.springcloud.eureka.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lutenglong.springcloud.eureka.entity.User;
import com.lutenglong.springcloud.eureka.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("list")
    public List<User> list(@RequestParam("id") Integer id){
        return  iUserService.list();
    }


    @RequestMapping("page")
    public Page<User> page(@RequestParam(defaultValue = "1")Integer current,@RequestParam(defaultValue = "3")Integer size,User user){
        Page<User> page = new Page<>(current, size);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("username",user.getUsername());
        return iUserService.page(page,userQueryWrapper);
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam("id")Integer id){
        return  iUserService.removeById(id);
    }

    @RequestMapping("deletes")
    public boolean deletes(Integer[] ids){
        return iUserService.removeByIds(new ArrayList<>(Arrays.asList(ids)));
    }

    @RequestMapping("insert")
    public boolean insert(@RequestBody User user){
        user.setCreateTime(new Date(System.currentTimeMillis()));
        System.err.println(user);
        boolean save = iUserService.save(user);
        return save;
    }

}

