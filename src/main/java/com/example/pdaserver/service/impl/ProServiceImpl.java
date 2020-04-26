package com.example.pdaserver.service.impl;

import com.example.pdaserver.common.ServerResponse;
import com.example.pdaserver.common.StackNoTree;
import com.example.pdaserver.dao.InvoicebacketsMapper;
import com.example.pdaserver.dao.InvoiceinfoMapper;
import com.example.pdaserver.dao.ProdetailMapper;
import com.example.pdaserver.entity.Invoicebackets;
import com.example.pdaserver.entity.Invoiceinfo;
import com.example.pdaserver.entity.Orderinfo;
import com.example.pdaserver.entity.Prodetail;
import com.example.pdaserver.service.ProService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private InvoicebacketsMapper invoicebacketsMapper;
    @Autowired
    private InvoiceinfoMapper invoiceinfoMapper;

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


    //发货流程
    @Override
    public ServerResponse sendpro(String invoiceno,String allno,int invoicetype) {
        Invoicebackets invoicebackets=new Invoicebackets();
        Invoiceinfo invoiceinfo=invoiceinfoMapper.selectByPrimaryKey(invoiceno);
        if(invoiceinfo==null)
        {
            return ServerResponse.createByErrorMessage("没有这个发货单");
        }
        Prodetail prodetail=new Prodetail();
        prodetail=prodetailMapper.selectByPrimaryKey(allno);
        if(prodetail==null)
        {
            return ServerResponse.createByErrorMessage("没有这个产品");
        }
        int result=0;
        Date date=new Date();
        invoicebackets.setBacketno(prodetail.getBacketno());
        invoicebackets.setStackno(prodetail.getStackno());
        invoicebackets.setProid(prodetail.getId());
        invoicebackets.setInvoicetype(invoicetype);
        invoicebackets.setInvoiceno(invoiceno);
        invoicebackets.setInvoicetime(date);
        invoicebackets.setIsupload(1);
        switch (invoicetype) {
            case 0: {
                //获取这个批次的产品数量
                result=prodetailMapper.selectByBatchNo(prodetail.getBacketno(),null).size();
                if(prodetailMapper.updateBybacketno(invoicebackets.getBacketno(),1)>=1)
                {
                    List<Invoicebackets> list=invoicebacketsMapper.selectBybacketno(prodetail.getBacketno());
                    //判断有没有来自同一个批次号的产品
                    if(list.size()==0)
                    {
                        if(invoicebacketsMapper.insert(invoicebackets)>=1)
                        {
                            invoiceinfo.setRealcount(invoiceinfo.getRealcount()+result);
                            invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                            return ServerResponse.createBySuccess(result);
                        }
                        return ServerResponse.createByErrorMessage("在插入发货单和产品关联出错");
                    }
                    else{
                            for(Invoicebackets invoicebackets1:list)
                            {
                                //如果有，且是否来自同一个发货单
                                if(invoiceno.equals(invoicebackets1.getInvoiceno()))
                                {
                                    switch (invoicebackets1.getInvoicetype())
                                    {
                                        case 0:return ServerResponse.createByErrorMessage("该批已发货");
                                        case 1: {
                                            invoicebacketsMapper.updateByPrimaryKeySelective(invoicebackets);
                                            //减去已经发的板数
                                            result=result-prodetailMapper.selectByStackno(prodetail.getStackno(),null).size();

                                        }
                                        case 2:{
                                            result=result-1;
                                            invoicebacketsMapper.updateByPrimaryKeySelective(invoicebackets);
                                        }
                                    }
                                }
                                //如果来自不同发货单
                                else{
                                    return ServerResponse.createByErrorMessage("已经被其他发货单发货");
                                }
                            }
                            //循环结束后才可以计算数量和得出结果
                        invoiceinfo.setRealcount(invoiceinfo.getRealcount()+result);
                        invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                        return ServerResponse.createBySuccess(result);
                    }

                }
                else{
                    return ServerResponse.createByErrorMessage("在更新已发状态时出错");
                }
            }
            case 1: {
                //获取这个板数的产品数量
                result=prodetailMapper.selectByStackno(prodetail.getStackno(),null).size();
                if(prodetailMapper.updateBystackno(invoicebackets.getStackno(),1)>=1)
                {
                    List<Invoicebackets> list=invoicebacketsMapper.selectBystackno(prodetail.getStackno());
                    //如果没有来自同一板的产品
                    if(list.size()==0)
                    {
                        if(invoicebacketsMapper.insert(invoicebackets)>=1)
                        {
                            invoiceinfo.setRealcount(invoiceinfo.getRealcount()+result);
                            invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                            return ServerResponse.createBySuccess(result);
                        }
                    }
                    //如果有来自同一板的产品
                    else{
                        for(Invoicebackets invoicebackets1:list)
                        {
                            //如果有，且来自同一个发货单
                            if(invoiceno.equals(invoicebackets1.getInvoiceno()))
                            {
                                switch (invoicebackets1.getInvoicetype())
                                {
                                    case 0:return ServerResponse.createByErrorMessage("该板已发货");
                                    case 1: {
                                        return ServerResponse.createByErrorMessage("该板已发货");
                                    }
                                    case 2:{
                                        invoicebacketsMapper.updateByPrimaryKeySelective(invoicebackets);
                                        result=result-1;

                                    }
                                }
                            }
                            //如果来自不同发货单
                            else{
                                return ServerResponse.createByErrorMessage("已经被其他发货单发货");
                            }
                        }
                        invoiceinfo.setRealcount(invoiceinfo.getRealcount()+result);
                        invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                        return ServerResponse.createBySuccess(result);

                    }

                    return ServerResponse.createByErrorMessage("在插入发货单和产品关联出错");
                }
                else{
                    return ServerResponse.createByErrorMessage("在更新已发状态时出错");
                }
            }
            case 2: {
                if(prodetailMapper.updateByid(invoicebackets.getProid(),1)>=1)
                {
                    if(invoicebacketsMapper.selectByproid(prodetail.getId()).size()==0)
                    {
                        if(invoicebacketsMapper.insert(invoicebackets)>=1)
                        {
                            invoiceinfo.setRealcount(invoiceinfo.getRealcount()+1);
                            invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                            return ServerResponse.createBySuccess();
                        }
                        else{
                            return ServerResponse.createByErrorMessage("在插入发货单和产品关联出错");
                        }
                    }
                    return ServerResponse.createByErrorMessage("该桶已经发货");
                }
                else{
                    return ServerResponse.createByErrorMessage("在更新已发状态时出错");
                }
            }
            default:return ServerResponse.createByErrorMessage("在更新已发状态时出错");
        }
    }

    //退货流程
    @Override
    public ServerResponse returnsales(String allno,int invoicetype) {
        Prodetail prodetail=new Prodetail();
        int result=0;
        prodetail=prodetailMapper.selectByPrimaryKey(allno);
        Invoiceinfo invoiceinfo;
        List<Invoicebackets> list=invoicebacketsMapper.selectByproid(allno);
        switch (invoicetype) {
            case 0: {
                if(prodetailMapper.updateBybacketno(prodetail.getBacketno(),0)>=1)
                {
                    for(Invoicebackets invoicebackets:list)
                    {
                        if(invoicebacketsMapper.deleteByPrimaryKey(invoicebackets.getId())>=1)
                        {
                            switch (invoicebackets.getInvoicetype()){
                                case 0:{
                                    int result1=prodetailMapper.selectByBatchNo(prodetail.getBacketno(),null).size();
                                    invoiceinfo=invoiceinfoMapper.selectByPrimaryKey(invoicebackets.getInvoiceno());
                                    invoiceinfo.setRealcount(invoiceinfo.getRealcount()-result1);
                                    invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                                    result=result+result1;
                                }break;
                                case 1:{
                                    invoiceinfo=invoiceinfoMapper.selectByPrimaryKey(invoicebackets.getInvoiceno());
                                    int result2=prodetailMapper.selectByStackno(prodetail.getStackno(),null).size();
                                    invoiceinfo.setRealcount(invoiceinfo.getRealcount()-result2);
                                    invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                                    result=result+result2;
                                }break;
                                case 2:{
                                    invoiceinfo=invoiceinfoMapper.selectByPrimaryKey(invoicebackets.getInvoiceno());
                                    invoiceinfo.setRealcount(invoiceinfo.getRealcount()-1);
                                    invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                                    result=result+1;
                                }break;
                            }

                        }
                    }
                    return ServerResponse.createBySuccess("退货成功",result);

                }
                else{
                    return ServerResponse.createByErrorMessage("在更新已发状态时出错");
                }
            }
            case 1: {
                if(prodetailMapper.updateBystackno(prodetail.getStackno(),0)>=1)
                {
                    for(Invoicebackets invoicebackets:list)
                    {
                        if(invoicebacketsMapper.deleteByPrimaryKey(invoicebackets.getId())>=1)
                        {
                            switch (invoicebackets.getInvoicetype()){
                                case 0:case 1:{
                                    int result1=prodetailMapper.selectByStackno(prodetail.getStackno(),null).size();
                                    invoiceinfo=invoiceinfoMapper.selectByPrimaryKey(invoicebackets.getInvoiceno());
                                    invoiceinfo.setRealcount(invoiceinfo.getRealcount()-result1);
                                    invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                                    result=result+result1;
                                }break;
                                case 2:{
                                    invoiceinfo=invoiceinfoMapper.selectByPrimaryKey(invoicebackets.getInvoiceno());
                                    invoiceinfo.setRealcount(invoiceinfo.getRealcount()-1);
                                    invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                                    result=result+1;
                                }break;
                            }
                        }
                    }
                    return ServerResponse.createBySuccess("退货成功",result);
                }
                else{
                    return ServerResponse.createByErrorMessage("在更新已发状态时出错");
                }
            }
            case 2: {
                if(prodetailMapper.updateByid(prodetail.getId(),0)>=1)
                {
                    for(Invoicebackets invoicebackets:list)
                    {
                        if(invoicebackets.getInvoicetype().equals(3))
                        {
                            if(invoicebacketsMapper.deleteByPrimaryKey(invoicebackets.getId())>=1)
                            {
                                invoiceinfo=invoiceinfoMapper.selectByPrimaryKey(invoicebackets.getInvoiceno());
                                invoiceinfo.setRealcount(invoiceinfo.getRealcount()-1);
                                invoiceinfoMapper.updateByPrimaryKeySelective(invoiceinfo);
                                result=result+1;
                            }
                        }
                    }
                    return ServerResponse.createBySuccess("退货成功",result);
                }
                else{
                    return ServerResponse.createByErrorMessage("在更新已发状态时出错");
                }
            }
            default:return ServerResponse.createByErrorMessage("在更新已发状态时出错");
        }
    }
}
