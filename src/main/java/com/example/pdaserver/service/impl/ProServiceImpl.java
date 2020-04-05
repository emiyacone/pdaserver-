package com.example.pdaserver.service.impl;

import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.dao.ProdetailMapper;
import com.example.pdaserver.entity.Orderinfo;
import com.example.pdaserver.entity.Prodetail;
import com.example.pdaserver.service.ProService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: pdaserver
 * @description:
 * @author: 唐庆阳
 * @create: 2020-04-05 14:44
 **/
@Service("proservice")
public class ProServiceImpl implements ProService {
    @Autowired
    private ProdetailMapper prodetailMapper;

    @Override
    public ServerResponse getProList(int pageNum, int pageSize) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Prodetail> ProList=prodetailMapper.selectlist();
        PageInfo pageresult=new PageInfo(ProList);
        return  ServerResponse.createBySuccess(pageresult);
    }

    @Override
    public ServerResponse getProListbyfacno(int pageNum, int pageSize, String facno) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Prodetail> ProList=prodetailMapper.selectlistbyfacno(facno);
        PageInfo pageresult=new PageInfo(ProList);
        return  ServerResponse.createBySuccess(pageresult);
    }
}
