package com.pg.vhrpg.config;

import com.pg.vhrpg.common.DateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: WebMvcConfigurer
 * @Description:
 * @Author: pg
 * @Date: 2019/12/3 15:31
 * @Version: 1.0
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateFormat());
    }
    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }
}
