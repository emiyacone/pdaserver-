package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Invoicebackets;

public interface InvoicebacketsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Invoicebackets record);

    int insertSelective(Invoicebackets record);

    Invoicebackets selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Invoicebackets record);

    int updateByPrimaryKey(Invoicebackets record);
}