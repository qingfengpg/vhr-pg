package com.pg.vhrpg.config;

import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ObjectPostProsser
 * @Description:
 * @Author: pg
 * @Date: 2019/12/3 23:19
 * @Version: 1.0
 **/
//@Component
public class ObjectPostProsser implements ObjectPostProcessor<FilterSecurityInterceptor> {

    @Override
    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
        // 设置安全元数据源(可访问的资源)
        o.setSecurityMetadataSource(null);
        // 设置访问决策管理器
        o.setAccessDecisionManager(null);
        return o;
    }
}
