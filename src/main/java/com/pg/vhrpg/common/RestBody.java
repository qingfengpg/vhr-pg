package com.pg.vhrpg.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: RestBody
 * @Description: 统一返回
 * @Author: pg
 * @Date: 2019/12/3 16:26
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestBody {
    private Integer status;
    private String msg;
    private Object data;


    public static RestBody build() {
        return new RestBody();
    }

    public static RestBody ok(String msg, Object data) {
        return new RestBody(200, msg, data);
    }

    public static RestBody ok(String msg) {
        return new RestBody(200, msg, null);
    }

    public static RestBody error(String msg, Object data) {
        return new RestBody(500, msg, data);
    }

    public static RestBody error(String msg) {
        return new RestBody(500, msg, null);
    }
}
