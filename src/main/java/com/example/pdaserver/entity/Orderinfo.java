package com.example.pdaserver.entity;

import java.util.Date;

public class Orderinfo {
    private String orderno;

    private String factoryname;

    private String factoryid;

    private String factorylineid;

    private String batchno;

    private String prono;

    private String proname;

    private String prdstyle;

    private Integer plancount;

    private Integer realcount;

    private Integer stacktotal;

    private Date startdate;

    private Date finishdate;

    private Integer isfinish;

    private String operator;

    private String descrip;

    private Integer isupload;

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