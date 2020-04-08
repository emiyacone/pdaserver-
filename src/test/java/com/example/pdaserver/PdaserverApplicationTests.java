package com.example.pdaserver;

import com.example.pdaserver.dao.OrderinfoMapper;
import com.example.pdaserver.dao.ProdetailMapper;
import com.example.pdaserver.service.OrderService;
import com.example.pdaserver.service.ProService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PdaserverApplicationTests {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProdetailMapper prodetailMapper;

    @Autowired
    private ProService proservice;
    @Test
    void contextLoads() {
       System.out.println(prodetailMapper.selectStacknoByBatch("1901164B72",null));
    }

}
