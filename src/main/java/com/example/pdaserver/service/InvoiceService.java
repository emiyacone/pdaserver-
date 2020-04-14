package com.example.pdaserver.service;

import com.example.pdaserver.common.ServerResponse;

public interface InvoiceService {
    ServerResponse getinvoiceList(int pageNum, int pageSize);
    ServerResponse getinvoicebyfacno(int pageNum, int pageSize,String facno);
    ServerResponse getinvoicebyno(String invoiceno);
}
