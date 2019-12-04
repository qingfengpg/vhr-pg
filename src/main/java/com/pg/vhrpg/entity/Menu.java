package com.pg.vhrpg.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *功能描述: 菜单实体
 * @author: pg
 * @date: 2019/12/4 22:04
 * @param:
 * @return:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private Boolean keepAlive;

    private Boolean requireAuth;

    private Integer parentId;

    private Boolean enabled;

    private List<Role> roles = new ArrayList<Role>();

    private List<Menu> children = new ArrayList<Menu>();
    private static final long serialVersionUID = 1L;
}
