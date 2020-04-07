package com.example.pdaserver.service.impl;

import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.common.StackNoTree;
import com.example.pdaserver.dao.ProdetailMapper;
import com.example.pdaserver.entity.Orderinfo;
import com.example.pdaserver.entity.Prodetail;
import com.example.pdaserver.service.ProService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//获取产品的三级菜单
    @Override
    public ServerResponse getProtree(String BatchNo, String facno) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        List<StackNoTree> protree=new ArrayList<>();
        List<String> stacknolist=prodetailMapper.selectStacknoByBatch(BatchNo,facno);
        StackNoTree stackTree=new StackNoTree();
        StackNoTree idtree=new StackNoTree();
        for(String stackno:stacknolist)
        {
            stackTree.setLabel(stackno);
            List<String> idlist=prodetailMapper.selectIdByStackno(stackno,facno);
            if(idlist.size()>0)
            {
                List<StackNoTree> stacktree=new ArrayList<>();
                for(String id:idlist)
                {
                    idtree.setLabel(id);
                }
                stacktree.add(idtree);
                stackTree.setChirden(stacktree);
            }
            protree.add(stackTree);
        }
        return  ServerResponse.createBySuccess("获取产品树成功",protree);
    }

    //根据id查询产品明细
    @Override
    public ServerResponse getprodetail(String id) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        Prodetail prodetail=prodetailMapper.selectByPrimaryKey(id);
        return  ServerResponse.createBySuccess(prodetail);
    }
}
