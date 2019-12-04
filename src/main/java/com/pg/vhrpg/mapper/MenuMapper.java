package com.pg.vhrpg.mapper;

import com.pg.vhrpg.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> findAllMenu();

    List<Menu> getMenusByHrId(@Param("hrId") Integer hrId);
}
