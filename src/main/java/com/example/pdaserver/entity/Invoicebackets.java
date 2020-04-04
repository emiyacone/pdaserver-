package com.example.pdaserver.entity;

import java.util.Date;

public class Invoicebackets {
    private String id;

    private String invoiceno;

    private String backetno;

    private Date invoicetime;

    private Integer isupload;

    private String facno;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
}