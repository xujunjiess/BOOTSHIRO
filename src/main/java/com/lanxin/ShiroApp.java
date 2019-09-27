package com.lanxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2019/9/26.
 */
@SpringBootApplication
@ComponentScan(value = "com.lanxin")
@MapperScan(value="com.lanxin.dao")
public class ShiroApp {
    public static void main(String[] args) {
        SpringApplication.run(ShiroApp.class,args);
    }
}
