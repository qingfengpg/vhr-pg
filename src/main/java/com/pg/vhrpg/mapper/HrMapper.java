package com.pg.vhrpg.mapper;

import com.pg.vhrpg.entity.Hr;
import org.apache.ibatis.annotations.Param;


public interface HrMapper {
    Hr findOneByHrId(@Param("id")Integer id);






}
