package com.pg.vhrpg.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pg.vhrpg.common.RestBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: LogoutSuccessHandler
 * @Description: 登出成功处理
 * @Author: pg
 * @Date: 2019/12/3 23:01
 * @Version: 1.0
 **/
@Component
public class LogoutSuccHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {
        res.setContentType("application/json;charset=utf-8");
        RestBody restBody = RestBody.ok("注销成功!");
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter pw = res.getWriter();
        pw.write(objectMapper.writeValueAsString(res));
        pw.flush();
        pw.close();
    }
}
