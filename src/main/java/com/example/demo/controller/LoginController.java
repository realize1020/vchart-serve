package com.example.demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.example.demo.utils.CodeUtils;
import com.example.demo.utils.ImageUtil;
import com.example.demo.utils.R;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RequestMapping("/code")
@RestController
public class LoginController {


    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    RedisTemplate redisTemplate;

    //验证码存入redis的前缀
    private static final String VERIFYCODE_PREFIX = "verifyCode:";

    //验证码存入redis的过期时间为一分钟
    private int expiredTime = 1000*60;

    //用来产生验证码
    @GetMapping("/verifyCode")
    public void generateImage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("verifyCode。。。。。。。。。。。。。。。。。");


        //1、第一种获得验证码的写法(求和验证码)
        final ImageUtil imageUtil = ImageUtil.getInstance();
        //验证码图片
        final ByteArrayInputStream image = imageUtil.getImage();
        //验证码文字
        final String verifyCode = imageUtil.getStr();
        request.getSession().setAttribute("verifyCode",verifyCode);

        //生成返回前端的uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println("uuid="+uuid);
        System.out.println("verifyCode="+verifyCode);

        //验证码存入redis
        redisTemplate.opsForValue().set(VERIFYCODE_PREFIX+uuid,verifyCode,expiredTime,TimeUnit.MILLISECONDS);

        response.setContentType("image/jpeg");
        response.setHeader("uuid",uuid);
        byte[] bytes = new byte[1024];
        try(final ServletOutputStream out = response.getOutputStream()){
            while (image.read(bytes)!= -1 ){
                out.write(bytes);
            }
        }


    }


    //返回base64的数据,uuid也放在R里
    @GetMapping("/verifyCode2")
    public R generateImage2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("verifyCode。。。。。。。。。。。。。。。。。");



        //4、第四种获得验证码的写法，Hutool工具实现LineCaptcha 线段干扰的验证码
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha =CaptchaUtil.createLineCaptcha(350,46,4,10);

        String code = lineCaptcha.getCode();

        request.getSession().setAttribute("code",code);

        //生成返回前端的uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-","");

        //验证码存入redis
        redisTemplate.opsForValue().set(VERIFYCODE_PREFIX+uuid,code,expiredTime,TimeUnit.MILLISECONDS);


        return R.ok().data("verifyImage",lineCaptcha.getImageBase64Data()).data("uuid",uuid);

    }


}
