package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Userinfo;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    int deleteByPrimaryKey(String userno);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String userno);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    int checkUsername(String username);

    Userinfo selectlogin(@Param("username") String username, @Param("password") String password);


}