package com.pg.vhrpg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = {"com.pg.vhrpg.mapper"})
@SpringBootApplication
public class VhrPgApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrPgApplication.class, args);
    }

}
