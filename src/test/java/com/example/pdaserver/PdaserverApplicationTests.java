package com.example.pdaserver;

import com.example.pdaserver.dao.OrderinfoMapper;
import com.example.pdaserver.dao.ProdetailMapper;
import com.example.pdaserver.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PdaserverApplicationTests {
    @Autowired
    private OrderService orderService;
    @Test
    void contextLoads() {
        System.out.println(orderService.getOrderList(1,2).getData());
    }

}
