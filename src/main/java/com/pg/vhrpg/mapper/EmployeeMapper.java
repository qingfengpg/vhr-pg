package com.pg.vhrpg.mapper;

import com.pg.vhrpg.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> list(@Param("start") Integer start, @Param("size") Integer size, @Param("keywords") String keywords);
}
