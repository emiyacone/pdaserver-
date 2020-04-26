package com.example.pdaserver.controller;

import com.example.pdaserver.common.Const;
import com.example.pdaserver.common.ResponseCode;
import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.entity.Userinfo;
import com.example.pdaserver.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: pdaserver
 * @description: 发货信息
 * @author: 唐庆阳
 * @create: 2020-04-05 15:56
 **/

@Controller
@RequestMapping("/invoice/")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceservice;

    //查询
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
            return invoiceservice.getinvoiceList(pageNum,pageSize);
        }
        else{
            return invoiceservice.getinvoicebyfacno(pageNum,pageSize,currentfacno);
        }

    }


    //通过发货单号查询
    @RequestMapping("listbyinvoiceno.do")
    @ResponseBody
    public ServerResponse listbyinvoiceno(@RequestParam("InvoiceNo") String invoiceno){
        return invoiceservice.getinvoicebyno(invoiceno);
    }
}
