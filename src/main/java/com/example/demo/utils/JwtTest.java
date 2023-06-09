package com.example.demo.utils;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 *@Author wang
 *@Date 2023/2/1 22 :37
 *@description
 */
public class JwtTest {

    private String privateKey = "D:/111/id_key_rsa";

    private String publicKey = "D:/111/id_key_rsa.pub";

    @Test
    public void test1() throws Exception {
        RsaUtils.generateKey(publicKey, privateKey, "dpb", 1024);
    }


    @Test
    public void test2() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123"));

        //PasswordEncoder passwordEncoder = new PasswordEncoder() ;
    }

}
