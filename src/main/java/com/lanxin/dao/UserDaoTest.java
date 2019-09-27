package com.lanxin.dao;

import com.lanxin.ShiroApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2019/9/26.
 */
@SpringBootTest(classes = {ShiroApp.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testSelectpassByusername() throws Exception {
        String username=userDao.selectpassByusername("zhangsan");
        System.out.println(username);
    }

    @Test
    public void testSelectrolesByusername() throws Exception {

    }

    @Test
    public void testSelectpermByusername() throws Exception {

    }
}