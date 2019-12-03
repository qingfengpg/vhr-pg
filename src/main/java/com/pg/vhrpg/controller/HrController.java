package com.pg.vhrpg.controller;

import com.pg.vhrpg.entity.Hr;
import com.pg.vhrpg.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HrController
 * @Description:
 * @Author: pg
 * @Date: 2019/12/3 14:02
 * @Version: 1.0
 **/
@RestController
@RequestMapping("hr")
public class HrController {
    @Autowired
    private HrService hrService;

    @RequestMapping(name = "findById", consumes = "application/json")
    public Hr findById(@RequestBody Hr hr) {
        return hrService.findById(hr);
    }
}
