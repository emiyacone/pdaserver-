package com.example.pdaserver.entity;

import java.util.Date;

public class Invoiceinfo {
    private String invoiceno;

    private String factoryname;

    private String factoryid;

    private String factorylineid;

    private String customerid;

    private String customername;

    private Date pickdate;

    private Integer plancount;

    private Integer realcount;

    private Integer rtncount;

    private String operator;

    private String descrip;

    private Integer isupload;

    private Integer invoicetype;

    private String facno;

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno == null ? null : invoiceno.trim();
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

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public Date getPickdate() {
        return pickdate;
    }

    public void setPickdate(Date pickdate) {
        this.pickdate = pickdate;
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

    public Integer getRtncount() {
        return rtncount;
    }

    public void setRtncount(Integer rtncount) {
        this.rtncount = rtncount;
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

    public Integer getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(Integer invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno == null ? null : facno.trim();
    }
}