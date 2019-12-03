package com.pg.vhrpg;

import com.pg.vhrpg.entity.Hr;
import com.pg.vhrpg.service.HrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VhrPgApplicationTests {

    @Autowired
    private HrService hrService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void findById() {
        Hr hr = new Hr();
        hr.setId(1);
        Hr hrById = hrService.findById(hr);
        System.out.println("hr===" + hrById);
    }
}
