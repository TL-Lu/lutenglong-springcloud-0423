package com.lutenglong.springcloud.eureka.entity;

import lombok.Data;

import java.util.List;

@Data
public class NationVo {
    private Integer id;

    private String name;

    private List<NationVo> list;
}
