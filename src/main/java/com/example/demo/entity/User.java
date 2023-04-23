package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_user")
@Data
public class User {

    private String id;

    private String username;

    private String password;

}
