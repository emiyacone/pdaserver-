package com.example.pdaserver.service.impl;

import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.dao.OrderinfoMapper;
import com.example.pdaserver.entity.Orderinfo;
import com.example.pdaserver.service.OrderService;
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
 * @create: 2020-04-05 14:01
 **/
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderinfoMapper orderinfoMapper;

    @Override
    public ServerResponse getOrderList(int pageNum, int pageSize) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Orderinfo> OrderList=orderinfoMapper.selectlist();
        PageInfo pageresult=new PageInfo(OrderList);
        return  ServerResponse.createBySuccess(pageresult);
    }


    @Override
    public ServerResponse getOrderListbyfacno(int pageNum, int pageSize,String facno) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Orderinfo> OrderList=orderinfoMapper.selectlistbyfacno(facno);
        PageInfo pageresult=new PageInfo(OrderList);
        return  ServerResponse.createBySuccess(pageresult);
    }


    @Override
    public ServerResponse search(int pageNum, int pageSize,String facno,String OrderNo,String BatchNo,String ProNo,String ProName) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        OrderNo=searchstyle(OrderNo);
        BatchNo=searchstyle(BatchNo);
        ProNo=searchstyle(ProNo);
        ProName=searchstyle(ProName);
        List<Orderinfo> OrderList=orderinfoMapper.selectlistbyFacNoAndOrerNoAndBacketNoAndProductNoAndProName(facno,OrderNo,BatchNo,ProNo,ProName);
        PageInfo pageresult=new PageInfo(OrderList);
        return  ServerResponse.createBySuccess(pageresult);
    }

    private String searchstyle(String param)
    {
        if(StringUtils.isNotBlank(param))
        {
            param=new StringBuilder().append("%").append(param).append("%").toString();
        }
        else{
            param=null;
        }
        return param;
    }
}
