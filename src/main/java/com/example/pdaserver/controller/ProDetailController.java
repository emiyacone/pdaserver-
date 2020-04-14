package com.example.pdaserver.controller;

import com.example.pdaserver.common.Const;
import com.example.pdaserver.common.ResponseCode;
import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.entity.Userinfo;
import com.example.pdaserver.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: pdaserver
 * @description:
 * @author: 唐庆阳
 * @create: 2020-04-05 14:47
 **/
@Controller
@RequestMapping("/prodetail/")
public class ProDetailController {
    @Autowired
    private ProService proservice;

    // 查询工单
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse getList(HttpSession session, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        Userinfo userinfo=(Userinfo)session.getAttribute(Const.CURRENT_USER);
        if(userinfo==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        String currentfacno=userinfo.getFacno();
        if("0".equals(currentfacno))
        {
            return proservice.getProList(pageNum,pageSize);
        }
        else{
            return proservice.getProListbyfacno(pageNum,pageSize,currentfacno);
        }

    }


    // 查询树
    @RequestMapping("listprotree.do")
    @ResponseBody
    public ServerResponse getlistprotree(HttpSession session,  @RequestParam("BatchNo") String Bactchno){
        Userinfo userinfo=(Userinfo)session.getAttribute(Const.CURRENT_USER);
        if(userinfo==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        String currentfacno=userinfo.getFacno();
        if("0".equals(currentfacno))
        {
            return proservice.getProtree(Bactchno,null);
        }
        else{
            return proservice.getProtree(Bactchno,currentfacno);
        }

    }

    // 查询树
    @RequestMapping("selectbyid.do")
    @ResponseBody
    public ServerResponse selectbyid(HttpSession session,  @RequestParam("ID") String id){
        Userinfo userinfo=(Userinfo)session.getAttribute(Const.CURRENT_USER);
        if(userinfo==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        return proservice.getprodetail(id);

    }

    // 根据板号查询
    @RequestMapping("selectbystackno.do")
    @ResponseBody
    public ServerResponse selectbystackno(HttpSession session,@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize , @RequestParam("StackNo") String stackno){
        Userinfo userinfo=(Userinfo)session.getAttribute(Const.CURRENT_USER);
        if(userinfo==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        String currentfacno=userinfo.getFacno();
        if("0".equals(currentfacno))
        {
            return proservice.getlistbystackno(pageNum,pageSize,stackno,null);
        }
        else{
            return proservice.getlistbystackno(pageNum,pageSize,stackno,currentfacno);
        }
    }

    // 根据板号查询
    @RequestMapping("selectbybatchno.do")
    @ResponseBody
    public ServerResponse selectbybatchno(HttpSession session,@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize , @RequestParam("BatchNo") String batchno){
        Userinfo userinfo=(Userinfo)session.getAttribute(Const.CURRENT_USER);
        if(userinfo==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        String currentfacno=userinfo.getFacno();
        if("0".equals(currentfacno))
        {
            return proservice.getlistbyBatchno(pageNum,pageSize,batchno,null);
        }
        else{
            return proservice.getlistbyBatchno(pageNum,pageSize,batchno,currentfacno);
        }
    }

    // 发货
    @RequestMapping("sendpro.do")
    @ResponseBody
    public ServerResponse sendpro( @RequestParam("InvoiceNo") String InvoiceNo , @RequestParam("ProId") String proid,@RequestParam("invoicetype")int invoicetype){
        return proservice.sendpro(InvoiceNo,proid,invoicetype);
    }

    // 退货
    @RequestMapping("returnpro.do")
    @ResponseBody
    public ServerResponse returnpro( @RequestParam("ProId") String proid,@RequestParam("invoicetype")int invoicetype){
        return proservice.returnsales(proid,invoicetype);
    }
}
