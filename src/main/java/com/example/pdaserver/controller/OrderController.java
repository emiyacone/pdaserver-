package com.example.pdaserver.controller;

import com.example.pdaserver.common.Const;
import com.example.pdaserver.common.ResponseCode;
import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.entity.Userinfo;
import com.example.pdaserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: pdaserver
 * @description: 工单查询
 * @author: 唐庆阳
 * @create: 2020-04-05 13:57
 **/

@Controller
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    private OrderService orderService;
    // 查询工单
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse getList(HttpSession session, @RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        Userinfo userinfo=(Userinfo)session.getAttribute(Const.CURRENT_USER);
        if(userinfo==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        String currentfacno=userinfo.getFacno();
        if("0".equals(currentfacno))
        {
            return orderService.getOrderList(pageNum,pageSize);
        }
        else{
            return orderService.getOrderListbyfacno(pageNum,pageSize,currentfacno);
        }

    }

    // 搜索工单
    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse search(HttpSession session, @RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,@RequestParam("OrderNo") String OrderNo,@RequestParam("BacketNo") String BacketNo,@RequestParam("ProNo") String ProNo,@RequestParam("Proname") String Proname){
        Userinfo userinfo=(Userinfo)session.getAttribute(Const.CURRENT_USER);
        if(userinfo==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        String currentfacno=userinfo.getFacno();
        if("0".equals(currentfacno))
        {
            return orderService.search(pageNum,pageSize,null,OrderNo,BacketNo,ProNo,Proname);
        }
        else{
            return orderService.search(pageNum,pageSize,currentfacno,OrderNo,BacketNo,ProNo,Proname);
        }

    }
}
