package com.pg.vhrpg.controller;

import com.pg.vhrpg.entity.Employee;
import com.pg.vhrpg.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: EmployeeController
 * @Description:
 * @Author: pg
 * @Date: 2019/12/5 14:45
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(name = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(defaultValue = "1") Integer page,
                    @RequestParam(defaultValue = "10") Integer size,
                    @RequestParam String keywords) {
        List<Employee> employeeList =  employeeService.list(page, size, keywords);
        Map<String, Object> map = new HashMap<>();
        map.put("emps", employeeList);
        map.put("count", employeeList.size());
        return map;
    }
}
