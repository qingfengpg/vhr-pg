package com.pg.vhrpg.controller;

import com.pg.vhrpg.entity.Menu;
import com.pg.vhrpg.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: ConfigController
 * @Description:
 * @Author: pg
 * @Date: 2019/12/4 22:40
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private MenuService menuService;
    @RequestMapping("/sysmenu")
    public List<Menu> systemMenu() {
       return menuService.getMenusByHrId();
    }

}
