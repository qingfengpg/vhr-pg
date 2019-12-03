package com.pg.vhrpg.common;

import com.pg.vhrpg.entity.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ClassName: HrUtil
 * @Description: 获取当前登录的Hr
 * @Author: pg
 * @Date: 2019/12/3 15:19
 * @Version: 1.0
 **/
public class HrUtil {
    public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
