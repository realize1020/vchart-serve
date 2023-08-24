package com.example.demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.example.demo.utils.CodeUtils;
import com.example.demo.utils.ImageUtil;
import com.example.demo.utils.R;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RequestMapping("/code")
@RestController
public class LoginController {


    @Autowired
    private DefaultKaptcha defaultKaptcha;
    //用来产生验证码
    @GetMapping("/verifyCode")
    public void generateImage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("verifyCode。。。。。。。。。。。。。。。。。");


        //1、第一种获得验证码的写法
        final ImageUtil imageUtil = ImageUtil.getInstance();
        //验证码图片
        final ByteArrayInputStream image = imageUtil.getImage();
        //验证码文字
        final String verifyCode = imageUtil.getStr();
        request.getSession().setAttribute("verifyCode",verifyCode);

        response.setContentType("image/jpeg");
        byte[] bytes = new byte[1024];
        try(final ServletOutputStream out = response.getOutputStream()){
            while (image.read(bytes)!= -1 ){
                out.write(bytes);
            }
        }




        //2、第二种获得验证码的写法
/*        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = defaultKaptcha.createText();
        // 生成图片验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        // 这里我们使用redis缓存验证码的值，并设置过期时间为60秒
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.flush();
        out.close();*/



        //3、第三种获得验证码的写法
//        CodeUtils code = new CodeUtils();
//        BufferedImage image = code.getImage();
//        String text = code.getText();
//        HttpSession session = request.getSession(true);
//        session.setAttribute("code", text);
//        CodeUtils.output(image,response.getOutputStream());



        //4、第四种获得验证码的写法，Hutool工具实现LineCaptcha 线段干扰的验证码
        //定义图形验证码的长和宽
//        LineCaptcha lineCaptcha =CaptchaUtil.createLineCaptcha(350,46,4,10);
//
//        String code = lineCaptcha.getCode();
//
//        request.getSession().setAttribute("code",code);
//
//
//        ServletOutputStream outputStream = response.getOutputStream();
//
//        lineCaptcha.write(outputStream);
//        outputStream.close();

    }


    //返回base64的数据
    @GetMapping("/verifyCode2")
    public String generateImage2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("verifyCode。。。。。。。。。。。。。。。。。");



        //4、第四种获得验证码的写法，Hutool工具实现LineCaptcha 线段干扰的验证码
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha =CaptchaUtil.createLineCaptcha(350,46,4,10);

        String code = lineCaptcha.getCode();

        request.getSession().setAttribute("code",code);


        return lineCaptcha.getImageBase64Data();

    }


}
