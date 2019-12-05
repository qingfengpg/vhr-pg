package com.pg.vhrpg.service;

import com.pg.vhrpg.entity.Employee;
import com.pg.vhrpg.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: EmployeeService
 * @Description:
 * @Author: pg
 * @Date: 2019/12/5 14:49
 * @Version: 1.0
 **/
@Slf4j
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> list(Integer page, Integer size, String keywords){
        int start = (page - 1 ) * size;
        log.info("查询条件：{}", page + "==="+size+"==="+keywords);
        return employeeMapper.list(start, size, keywords);
    }
}
