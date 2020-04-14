package com.example.pdaserver.service.impl;

import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.dao.InvoiceinfoMapper;
import com.example.pdaserver.entity.Invoiceinfo;
import com.example.pdaserver.service.InvoiceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: pdaserver
 * @description:
 * @author: 唐庆阳
 * @create: 2020-04-05 16:04
 **/
@Service("invoiceservice")
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceinfoMapper invoiceinfoMapper;

    @Override
    public ServerResponse getinvoiceList(int pageNum, int pageSize) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Invoiceinfo> invoiceList=invoiceinfoMapper.selectlist();
        PageInfo pageresult=new PageInfo(invoiceList);
        return  ServerResponse.createBySuccess(pageresult);
    }

    @Override
    public ServerResponse getinvoicebyfacno(int pageNum, int pageSize, String facno) {

        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Invoiceinfo> invoiceList=invoiceinfoMapper.selectlistbyfacno(facno);
        PageInfo pageresult=new PageInfo(invoiceList);
        return  ServerResponse.createBySuccess(pageresult);
    }

    @Override
    public ServerResponse getinvoicebyno(String invoiceno) {

        Invoiceinfo invoiceinfo=new Invoiceinfo();
        invoiceinfo=invoiceinfoMapper.selectByPrimaryKey(invoiceno);
        return  ServerResponse.createBySuccess(invoiceinfo);
    }

}
