package com.example.pdaserver.service.impl;

import com.example.pdaserver.common.Const;
import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.dao.UserinfoMapper;
import com.example.pdaserver.entity.Prodetail;
import com.example.pdaserver.entity.Userinfo;
import com.example.pdaserver.service.UserService;
import com.example.pdaserver.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: pdaserver
 * @description:
 * @author: 唐庆阳
 * @create: 2020-04-04 20:57
 **/

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserinfoMapper userMapper;

    public static final  String TOKEN_PREFIX="token_";

    @Override
    public ServerResponse<Userinfo> login(String username, String password) {
        int resultcont=userMapper.checkUsername(username);
        if(resultcont==0)
        {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //密码MD5
        String md5password= MD5Util.MD5EncodeUtf8(password);
        Userinfo user=userMapper.selectlogin(username,md5password);
        if(user==null)
        {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPwd(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功",user);
    }


    //注册
    @Override
    public ServerResponse<String> register(Userinfo user){

        //MD5加密
        user.setPwd(MD5Util.MD5EncodeUtf8(user.getPwd()));
        int  resultcont=userMapper.insert(user);
        if(resultcont==0)
        {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return  ServerResponse.createBySuccessMessage("注册成功");
    }

    //注册
    @Override
    public ServerResponse getlist(int pageNum,int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<Userinfo> userllist=userMapper.selectlist();
        PageInfo pageresult=new PageInfo(userllist);
        return  ServerResponse.createBySuccess(pageresult);
    }
}
