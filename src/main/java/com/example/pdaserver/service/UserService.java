package com.example.pdaserver.service;

import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.entity.Userinfo;

/**
 * @program: pdaserver
 * @description: 用户逻辑层
 * @author: 唐庆阳
 * @create: 2020-04-04 15:13
 **/
public interface UserService {
    ServerResponse<Userinfo> login(String username, String password);
    ServerResponse<String> register(Userinfo user);
    ServerResponse getlist(int pageNum,int pageSize);
}
