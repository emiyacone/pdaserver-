package com.example.pdaserver;

import com.example.pdaserver.dao.OrderinfoMapper;
import com.example.pdaserver.dao.ProdetailMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PdaserverApplicationTests {
    @Autowired
    private OrderinfoMapper orderinfoMapper;
    @Test
    void contextLoads() {
        System.out.println(orderinfoMapper.selectlistbyFacNoAndOrerNoAndBacketNoAndProductNoAndProName(null,"%8%",null,null,null).size());
    }

}
