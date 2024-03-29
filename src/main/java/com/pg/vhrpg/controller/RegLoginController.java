package com.pg.vhrpg.controller;

import com.pg.vhrpg.common.RestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sang on 2017/12/29.
 */
@RestController
public class RegLoginController {
    @RequestMapping("/login_p")
    public RestBody login() {
        return RestBody.error("尚未登录，请登录!");
    }
    @GetMapping("/employee/advanced/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/employee/basic/hello")
    public String basicHello() {
        return "basicHello";
    }
}
