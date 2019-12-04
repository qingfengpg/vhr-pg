package com.pg.vhrpg.config;

import com.pg.vhrpg.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: WebSecurityConfig
 * @Description:
 * @Author: pg
 * @Date: 2019/12/3 15:39
 * @Version: 1.0
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FailureHandler failureHandler;
    @Autowired
    private LogoutSuccHandler logoutSuccHandler;
    @Autowired
    private AuthDeniedHandler authDeniedHandler;
    //@Autowired
    //private ObjectPostProsser objectPostProsser;
    @Autowired
    private HrService hrService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/system");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().withObjectPostProcessor(new ObjectPostProsser())
                .and().formLogin().loginPage("/login_p").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(failureHandler).permitAll()
                .and().logout().logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccHandler)
                .permitAll().and().csrf().disable()
                // 拒绝访问处理
                .exceptionHandling().accessDeniedHandler(authDeniedHandler);
    }
}
