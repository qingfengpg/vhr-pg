package com.pg.vhrpg.mapper;

import com.pg.vhrpg.entity.Hr;
import org.apache.ibatis.annotations.Param;


public interface HrMapper {
    /**
     *功能描述: 根据id查询
     * @author: pg
     * @date: 2019/12/4 17:58
     * @param:
     * @return: com.pg.vhrpg.entity.Hr
     */
    Hr findOneByHrId(@Param("id")Integer id);
    /**
     *功能描述: 根据用户名查询hr及角色信息
     * @author: pg
     * @date: 2019/12/4 17:57
     * @param:
     * @return: com.pg.vhrpg.entity.Hr
     */
    Hr loadHrByUserName(@Param("userName") String userName);
}
