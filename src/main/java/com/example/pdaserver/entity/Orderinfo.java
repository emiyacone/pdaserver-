package com.example.pdaserver.entity;

import java.util.Date;

// 工单
public class Orderinfo {
    private String orderno;//工单号

    private String factoryname;//工厂名称

    private String factoryid;//工厂id

    private String factorylineid;

    private String batchno;//批次号

    private String prono;//产品号

    private String proname;//产品名称

    private String prdstyle;//产品规格

    private Integer plancount;// 计划产量

    private Integer realcount;// 实际产量

    private Integer stacktotal;// 板数

    private Date startdate;// 开始时间

    private Date finishdate;// 完成时间

    private Integer isfinish;

    private String operator;

    private String descrip;

    private Integer isupload;// 上传服务器状态

    private Date gettime;

    private Date uploadtime;

    private String facno;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getFactoryname() {
        return factoryname;
    }

    public void setFactoryname(String factoryname) {
        this.factoryname = factoryname == null ? null : factoryname.trim();
    }

    public String getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(String factoryid) {
        this.factoryid = factoryid == null ? null : factoryid.trim();
    }

    public String getFactorylineid() {
        return factorylineid;
    }

    public void setFactorylineid(String factorylineid) {
        this.factorylineid = factorylineid == null ? null : factorylineid.trim();
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono == null ? null : prono.trim();
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public String getPrdstyle() {
        return prdstyle;
    }

    public void setPrdstyle(String prdstyle) {
        this.prdstyle = prdstyle == null ? null : prdstyle.trim();
    }

    public Integer getPlancount() {
        return plancount;
    }

    public void setPlancount(Integer plancount) {
        this.plancount = plancount;
    }

    public Integer getRealcount() {
        return realcount;
    }

    public void setRealcount(Integer realcount) {
        this.realcount = realcount;
    }

    public Integer getStacktotal() {
        return stacktotal;
    }

    public void setStacktotal(Integer stacktotal) {
        this.stacktotal = stacktotal;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Integer getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(Integer isfinish) {
        this.isfinish = isfinish;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip == null ? null : descrip.trim();
    }

    public Integer getIsupload() {
        return isupload;
    }

    public void setIsupload(Integer isupload) {
        this.isupload = isupload;
    }

    public Date getGettime() {
        return gettime;
    }

    public void setGettime(Date gettime) {
        this.gettime = gettime;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno == null ? null : facno.trim();
    }
}