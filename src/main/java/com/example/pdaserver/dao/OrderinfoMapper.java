package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Orderinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderinfoMapper {
    int deleteByPrimaryKey(String orderno);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(String orderno);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);

    List<Orderinfo> selectlist();

    List<Orderinfo> selectlistbyfacno(String facno);

    List<Orderinfo> selectlistbyFacNoAndOrerNoAndBacketNoAndProductNoAndProName(@Param("facno") String facno,@Param("OrderNo") String OrderNo,@Param("BacketNo") String BacketNo,@Param("ProNo") String ProNo,@Param("Proname") String Proname);
}