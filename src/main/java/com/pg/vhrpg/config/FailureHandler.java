package com.pg.vhrpg.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pg.vhrpg.common.RestBody;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: FailureHandler
 * @Description: 验证失败处理逻辑
 * @Author: pg
 * @Date: 2019/12/3 22:34
 * @Version: 1.0
 **/
@Component
public class FailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        res.setContentType("application/json;charset=uft-8");
        RestBody restBody = null;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
            restBody = RestBody.error("账户名或密码输入错误!");
        } else if (e instanceof LockedException) {
            restBody = RestBody.error("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            restBody = RestBody.error("密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            restBody = RestBody.error("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            restBody = RestBody.error("账户被禁用，请联系管理员!");
        } else {
            restBody = RestBody.error("登陆失败!");
        }
        restBody.setStatus(401);
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter pw = res.getWriter();
        pw.write(objectMapper.writeValueAsString(restBody));
        pw.flush();
        pw.close();
    }
}
