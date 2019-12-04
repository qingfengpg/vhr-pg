package com.pg.vhrpg.service;

import com.pg.vhrpg.common.HrUtil;
import com.pg.vhrpg.entity.Menu;
import com.pg.vhrpg.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: MenuService
 * @Description:
 * @Author: pg
 * @Date: 2019/12/4 11:21
 * @Version: 1.0
 **/
@Service
@Transactional
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<Menu> getMenusByHrId() {
      return   menuMapper.getMenusByHrId(HrUtil.getCurrentHr().getId());
    }

}
