package com.example.pdaserver.service;

import com.example.pdaserver.common.ServerResponse;

public interface ProService {
    ServerResponse getProList(int pageNum, int pageSize);
    ServerResponse getProListbyfacno(int pageNum, int pageSize,String facno);
    ServerResponse getProtree(String BatchNo, String facno);
    ServerResponse getprodetail(String id);
    ServerResponse getlistbystackno(int pageNum,int pageSize,String stackno,String facno);
    ServerResponse getlistbyBatchno(int pageNum,int pageSize,String batchno,String facno);
}
