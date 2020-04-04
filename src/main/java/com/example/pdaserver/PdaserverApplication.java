package com.example.pdaserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.pdaserver.dao")
@SpringBootApplication
public class PdaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdaserverApplication.class, args);
    }

}
