package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Invoicebackets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvoicebacketsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Invoicebackets record);

    int insertSelective(Invoicebackets record);

    Invoicebackets selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invoicebackets record);

    int updateByPrimaryKey(Invoicebackets record);

    List<Invoicebackets> selectBybacketno(@Param("backetno")String backetno);

    List<Invoicebackets> selectByinvoiceno(@Param("invoiceno")String invoiceno);

    List<Invoicebackets> selectBystackno(@Param("stackno")String stackno);

    List<Invoicebackets> selectByproid(@Param("proid")String proid);
}