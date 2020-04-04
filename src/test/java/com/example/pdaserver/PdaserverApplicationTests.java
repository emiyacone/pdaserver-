package com.example.pdaserver;

import com.example.pdaserver.dao.ProdetailMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PdaserverApplicationTests {
    @Autowired
    private ProdetailMapper prodetailMapper;
    @Test
    void contextLoads() {
        System.out.println(prodetailMapper.selectByPrimaryKey("bc65de76-65c2-11e9-8c28-00090faa0001").getBacketno());
    }

}
