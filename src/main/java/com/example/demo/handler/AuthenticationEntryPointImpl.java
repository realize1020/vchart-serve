package com.example.demo.handler;

import com.alibaba.fastjson.JSON;
import com.example.demo.utils.AjaxResult;
import com.example.demo.utils.ServletUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/*
 *@Author wang
 *@Date 2023/2/1 17 :34
 *@description
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {


    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        int code = HttpStatus.UNAUTHORIZED.value();

        String msg = "认证失败，无法访问系统资源，请先登陆";

        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
    }
}
