package com.example.pdaserver.service;

import com.example.pdaserver.common.ServerResponse;

public interface ProService {
    ServerResponse getProList(int pageNum, int pageSize);
    ServerResponse getProListbyfacno(int pageNum, int pageSize,String facno);
}
