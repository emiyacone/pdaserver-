package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Invoiceinfo;

public interface InvoiceinfoMapper {
    int deleteByPrimaryKey(String invoiceno);

    int insert(Invoiceinfo record);

    int insertSelective(Invoiceinfo record);

    Invoiceinfo selectByPrimaryKey(String invoiceno);

    int updateByPrimaryKeySelective(Invoiceinfo record);

    int updateByPrimaryKey(Invoiceinfo record);
}