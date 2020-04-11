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
        //产品树
        List<StackNoTree> protree=new ArrayList<>();
        //获取板号
        List<String> stacknolist=prodetailMapper.selectStacknoByBatch(BatchNo,facno);
        //父节点板树
        StackNoTree stackTree;

        if(stacknolist.size()>0)
        {
            for(String stackno:stacknolist)
            {
                stackTree=new StackNoTree();
                stackTree.setLabel(stackno);
                stackTree.setIsleaf(false);
                List<String> idlist=prodetailMapper.selectIdByStackno(stackno,facno);
                if(idlist.size()>0)
                {
                    List<StackNoTree> stacktree=new ArrayList<>();
                    StackNoTree idtree;
                    for(String id:idlist)
                    {
                        //子节点id树
                        idtree=new StackNoTree();
                        idtree.setLabel(id);
                        idtree.setIsleaf(true);
                        stacktree.add(idtree);
                    }

                    stackTree.setChirden(stacktree);
                }
                protree.add(stackTree);
            }
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

    //根据stackno查询产品明细
    @Override
    public ServerResponse getlistbystackno(int pageNum,int pageSize,String stackno,String facno) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Prodetail> ProList=prodetailMapper.selectByStackno(stackno,facno);
        PageInfo pageresult=new PageInfo(ProList);
        return  ServerResponse.createBySuccess(pageresult);
    }


    //根据stackno查询产品明细
    @Override
    public ServerResponse getlistbyBatchno(int pageNum,int pageSize,String batchno,String facno) {
        //startpage--start
        //填充数据
        //pagehelper收尾
        PageHelper.startPage(pageNum,pageSize);
        List<StackNoTree> protree=new ArrayList<>();
        List<String> stacknolist=prodetailMapper.selectStacknoByBatch(batchno,facno);
        StackNoTree stackTree;
        for(String stackno:stacknolist)
        {
            stackTree=new StackNoTree();
            stackTree.setLabel(stackno);
            protree.add(stackTree);
        }
        PageInfo pageresult=new PageInfo(protree);
        return  ServerResponse.createBySuccess(pageresult);
    }
}
