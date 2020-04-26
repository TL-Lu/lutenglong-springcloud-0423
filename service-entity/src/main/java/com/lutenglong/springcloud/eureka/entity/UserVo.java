package com.lutenglong.springcloud.eureka.entity;

import lombok.Data;

@Data
public class UserVo extends User {

    private String province;
    private String city;
    private String county;
}
