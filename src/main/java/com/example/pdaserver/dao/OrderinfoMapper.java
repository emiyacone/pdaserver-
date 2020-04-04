package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Orderinfo;

public interface OrderinfoMapper {
    int deleteByPrimaryKey(String orderno);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(String orderno);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);
}