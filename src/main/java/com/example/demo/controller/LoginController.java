package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/system/index")
public class LoginController {

//    @Autowired
//    private UserService userService;
//
//
//    @RequestMapping("/login")
//    @CrossOrigin
//    public Result<?> login(@RequestBody User user){
//        User userLogin = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword()));
//        if(userLogin != null){
//            return Result.success("登录成功");
//        }else{
//            return  Result.fail("登录失败");
//        }
//
//    }

}
