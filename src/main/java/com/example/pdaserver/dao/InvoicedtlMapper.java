package com.example.pdaserver.dao;

import com.example.pdaserver.entity.Invoicedtl;

public interface InvoicedtlMapper {
    int deleteByPrimaryKey(String id);

    int insert(Invoicedtl record);

    int insertSelective(Invoicedtl record);

    Invoicedtl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Invoicedtl record);

    int updateByPrimaryKey(Invoicedtl record);
}