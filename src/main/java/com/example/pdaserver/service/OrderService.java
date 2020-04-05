package com.example.pdaserver.service;

import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.entity.Orderinfo;

import java.util.List;

public interface OrderService {
    ServerResponse getOrderList(int pageNum,int pageSize);
    ServerResponse getOrderListbyfacno(int pageNum, int pageSize,String facno);
    ServerResponse search(int pageNum, int pageSize,String facno,String OrderNo,String BatchNo,String ProNo,String ProName);

    }
