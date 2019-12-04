package com.pg.vhrpg.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pg.vhrpg.common.HrUtil;
import com.pg.vhrpg.common.RestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: LoginSuccessHandler
 * @Description:
 * @Author: pg
 * @Date: 2019/12/4 15:02
 * @Version: 1.0
 **/
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {
        res.setContentType("application/json;charset=utf-8");
        RestBody restBody = RestBody.ok("登陆成功!", HrUtil.getCurrentHr());
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter pw = res.getWriter();
        pw.write(objectMapper.writeValueAsString(restBody));
        pw.flush();
        pw.close();
        log.info("当前登录用户：{}", HrUtil.getCurrentHr());
    }
}
