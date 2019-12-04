package com.pg.vhrpg.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pg.vhrpg.common.RestBody;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: AuthDeniedHandler
 * @Description: 拒绝访问处理（没有权限）
 * @Author: pg
 * @Date: 2019/12/3 23:08
 * @Version: 1.0
 **/
@Component
public class AuthDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException e) throws IOException, ServletException {
        res.setStatus(HttpServletResponse.SC_FORBIDDEN);
        res.setContentType("application/json;charset=utf-8");
        RestBody restBody = RestBody.error("权限不足，禁止访问，请联系管理员!");
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter pw = res.getWriter();
        pw.write(objectMapper.writeValueAsString(restBody));
        pw.flush();
        pw.close();
    }
}
