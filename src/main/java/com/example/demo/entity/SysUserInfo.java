package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/*
 *@Author wang
 *@Date 2023/2/1 21 :54
 *@description 接收前端请求参数
 */
@Data
@TableName(value = "sys_user")
public class SysUserInfo implements Serializable {

    private String id;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;

}
