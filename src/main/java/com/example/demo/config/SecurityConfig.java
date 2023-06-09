package com.example.demo.config;

import com.example.demo.filter.TokenLoginFilter;
import com.example.demo.filter.TokenVerifyFilter;
import com.example.demo.handler.AuthenticationEntryPointImpl;
import com.example.demo.service.UserService;
import com.example.demo.utils.MD5PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
 *@Author wang
 *@Date 2023/2/1 17 :17
 *@description
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //认证失败处理类
    @Autowired
    private AuthenticationEntryPointImpl unauthorizedHandler;

    //提供公钥私钥的配置类,使用RSA加密方式
    //@Autowired
    //private RsaKeyProperties prop;

    //使用MD5加密方式
    @Autowired
    private MD5PasswordEncoder md5PasswordEncoder;

    @Autowired
    private UserService userService;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }


    /**
     * 身份认证接口
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                // CSRF禁用，因为不使用session
                .csrf().disable()
                // 认证失败处理类
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 过滤请求
                .authorizeRequests()
               // .antMatchers("/login").anonymous()// 对于登录login 允许匿名访问
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable();

        // 添加JWT filter
        httpSecurity.addFilter(new TokenLoginFilter(super.authenticationManager(), null));
                //.addFilter(new TokenVerifyFilter(super.authenticationManager(), null));

    }

    //指定认证对象的来源
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService)
                //从前端传递过来的密码就会被加密，所以从数据库
                //查询到的密码必须是经过加密的，而这个过程都是
                //在用户注册的时候进行加密的。
                .passwordEncoder(md5PasswordEncoder);
    }

    //RSA密码加密
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
//「拦截规则」
//
//        anyRequest：匹配所有请求路径
//        access：SpringEl表达式结果为true时可以访问
//        anonymous：匿名可以访问
//        denyAll：用户不能访问
//        fullyAuthenticated：用户完全认证可以访问（非remember-me下自动登录）
//        hasAnyAuthority：如果有参数，参数表示权限，则其中任何一个权限可以访问
//        hasAnyRole：如果有参数，参数表示角色，则其中任何一个角色可以访问
//        hasAuthority：如果有参数，参数表示权限，则其权限可以访问
//        hasIpAddress：如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
//        hasRole：如果有参数，参数表示角色，则其角色可以访问
//        permitAll：用户可以任意访问
//        rememberMe：允许通过remember-me登录的用户访问
//        authenticated：用户登录后可访问