package com.lutenglong.springcloud.eureka.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lutenglong.springcloud.eureka.entity.NationVo;
import com.lutenglong.springcloud.eureka.entity.User;
import com.lutenglong.springcloud.eureka.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

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

    /**
     * 添加的接口
     * @param user
     * @return
     */
    @RequestMapping("insert")
    public boolean insert(@RequestBody User user){
        user.setCreateTime(new Date(System.currentTimeMillis()));
        System.err.println(user);
        boolean save = iUserService.save(user);
        return save;
    }

    /**
     * 联动的接口  地区查询
     * @return
     */
    @RequestMapping("cascader")
    public List<NationVo> cascader(){
        return iUserService.cascader();
    }

    /**
     * 修改的接口
     * @param user
     * @return
     */
    @RequestMapping("updata")
    public boolean updata(@RequestBody User user){
        return iUserService.updateById(user);
    }


    /**
     * 图片上传的接口
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        try {
            //判断上传的文件了
            if (file != null && !file.isEmpty()) {
                //上传路径地址
                String path = "D:\\pic\\";
                //重新命名文件的名称
                String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                //创建文件对象
                File destFile = new File(path, fileName);
                //当前文件进行拷贝
                file.transferTo(destFile);
                //返回图片的路径地址
                return "http://localhost:99/"+fileName;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "upload";
    }
}

