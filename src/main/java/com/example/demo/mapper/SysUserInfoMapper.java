package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.SysUserInfo;
import com.example.demo.entity.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 *@Author wang
 *@Date 2023/2/1 21 :53
 *@description
 */
@Mapper
public interface SysUserInfoMapper extends BaseMapper<SysUserInfo> {

    //通过用户名密码获取用户信息
    SysUserInfo getUserByLogin(@Param("username") String username);

    //通过用户名获取角色
    String getRole(@Param("username") String username);

    UserPojo queryByUserName(@Param("userName") String userName);
}
