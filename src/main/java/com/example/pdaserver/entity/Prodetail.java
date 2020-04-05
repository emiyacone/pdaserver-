package com.example.pdaserver.entity;

import java.util.Date;

// 产品明细
public class Prodetail {
    private String id;

    private String orderno;

    private String backetno;

    private String stackno;

    private Integer cnt;

    private Integer stackcount;

    private Date prodate;

    private String operator;

    private Integer isupload;

    private Integer isdelete;

    private Date deldate;

    private Integer isinvoice;

    private Date gettime;

    private Date uploadtime;

    private String facno;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getBacketno() {
        return backetno;
    }

    public void setBacketno(String backetno) {
        this.backetno = backetno == null ? null : backetno.trim();
    }

    public String getStackno() {
        return stackno;
    }

    public void setStackno(String stackno) {
        this.stackno = stackno == null ? null : stackno.trim();
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getStackcount() {
        return stackcount;
    }

    public void setStackcount(Integer stackcount) {
        this.stackcount = stackcount;
    }

    public Date getProdate() {
        return prodate;
    }

    public void setProdate(Date prodate) {
        this.prodate = prodate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Integer getIsupload() {
        return isupload;
    }

    public void setIsupload(Integer isupload) {
        this.isupload = isupload;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getDeldate() {
        return deldate;
    }

    public void setDeldate(Date deldate) {
        this.deldate = deldate;
    }

    public Integer getIsinvoice() {
        return isinvoice;
    }

    public void setIsinvoice(Integer isinvoice) {
        this.isinvoice = isinvoice;
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