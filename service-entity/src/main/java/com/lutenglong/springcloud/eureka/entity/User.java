package com.lutenglong.springcloud.eureka.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField("createTime")
    private Date createTime;

    private String img;
    @TableField("proviceId")
    private Integer proviceId;
    @TableField("cityId")
    private Integer cityId;
    @TableField("countyId")
    private Integer countyId;
}
