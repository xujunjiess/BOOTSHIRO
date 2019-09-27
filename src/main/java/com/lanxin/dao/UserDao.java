package com.lanxin.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/9/26.
 */
@Mapper
public interface UserDao {
    public String selectpassByusername(String username);

    public List<String> selectrolesByusername(String username);

    public List<String> selectpermByusername(String username);
}
