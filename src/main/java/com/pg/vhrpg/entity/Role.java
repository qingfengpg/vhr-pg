package com.pg.vhrpg.entity;

import java.io.Serializable;
import lombok.Data;
/**
 *功能描述: 角色实体
 * @author: pg
 * @date: 2019/12/3 11:08
 * @param:
 * @return:
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * 角色ID
    */
    private Integer id;

    private String name;

    /**
    * 角色名称
    */
    private String nameZh;

}
