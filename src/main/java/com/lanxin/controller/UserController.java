package com.lanxin.controller;

import com.lanxin.dao.UserDao;
import com.lanxin.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/9/26.
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "/login")
    public Result login(String username,String password){
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("账号不存在");
            return Result.filed();
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return Result.filed();
        }
        return Result.ok();
    }
    @RequestMapping(value = "/nologin")
    public Result nologin(){
        System.out.println("未登陆");
        return Result.filed();
    }
    @RequiresRoles(value = "manage",logical = Logical.OR)
    @RequestMapping(value = "/select")
    public Result selectuser(){
        return Result.ok();
    }
    @RequiresRoles(value = {"manage","editer"},logical = Logical.OR)
    @RequestMapping(value = "/update")
    public Result updateuser(){
        return Result.ok();
    }


}
