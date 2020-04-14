package com.example.pdaserver.entity;

import java.util.Date;

public class Invoicebackets {
    private Integer id;

    private String invoiceno;

    private String backetno;

    private Date invoicetime;

    private Integer isupload;

    private String facno;

    private Integer invoicetype;

    private String stackno;

    private String proid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno == null ? null : invoiceno.trim();
    }

    public String getBacketno() {
        return backetno;
    }

    public void setBacketno(String backetno) {
        this.backetno = backetno == null ? null : backetno.trim();
    }

    public Date getInvoicetime() {
        return invoicetime;
    }

    public void setInvoicetime(Date invoicetime) {
        this.invoicetime = invoicetime;
    }

    public Integer getIsupload() {
        return isupload;
    }

    public void setIsupload(Integer isupload) {
        this.isupload = isupload;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno == null ? null : facno.trim();
    }

    public Integer getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(Integer invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getStackno() {
        return stackno;
    }

    public void setStackno(String stackno) {
        this.stackno = stackno == null ? null : stackno.trim();
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }
}