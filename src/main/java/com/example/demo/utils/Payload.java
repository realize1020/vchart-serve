package com.example.demo.utils;

import lombok.Data;

import java.util.Date;

/*
 *@Author wang
 *@Date 2023/2/1 22 :07
 *@description
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}
