package com.example.pdaserver.controller;

import com.example.pdaserver.common.Const;
import com.example.pdaserver.common.ResponseCode;
import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.entity.Userinfo;
import com.example.pdaserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: pdaserver
 * @description: 用户控制层
 * @author: 唐庆阳
 * @create: 2020-04-04 21:21
 **/
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService UserService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Userinfo> login(String username, String password, HttpSession session){
        ServerResponse<Userinfo> response=UserService.login(username,password);
        if(response.isSuccess())
        {
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(Userinfo user)
    {
        return UserService.register(user);
    }

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> list(HttpSession session, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize)
    {
        Userinfo userinfo=(Userinfo)session.getAttribute(Const.CURRENT_USER);
        if(userinfo==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        String currentfacno=userinfo.getFacno();
        if("0".equals(currentfacno))
        {
            return UserService.getlist(pageNum,pageSize);
        }
        else{
            return ServerResponse.createByErrorMessage("不是超级管理员");
        }

    }
}
