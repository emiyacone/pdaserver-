package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Prodetail;

public interface ProdetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(Prodetail record);

    int insertSelective(Prodetail record);

    Prodetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Prodetail record);

    int updateByPrimaryKey(Prodetail record);
}