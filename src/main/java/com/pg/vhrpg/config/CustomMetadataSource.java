package com.pg.vhrpg.config;

import com.pg.vhrpg.entity.Menu;
import com.pg.vhrpg.entity.Role;
import com.pg.vhrpg.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName: customMetadataSource
 * @Description:
 * @Author: pg
 * @Date: 2019/12/3 23:43
 * @Version: 1.0
 **/
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    private MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 获取menu菜单，循环菜单的资源地址和请求的url比较，且有角色，返回角色
        List<Menu> menus = menuService.findAllMenu();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl) && menu.getRoles().size() > 0) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i<size; i++) {
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        // 没有匹配到，都需要登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
