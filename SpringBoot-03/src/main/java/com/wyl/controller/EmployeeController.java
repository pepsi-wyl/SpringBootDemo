package com.wyl.controller;

import com.wyl.mapper.EmployeeMapper;
import com.wyl.pojo.Employee;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/11/22.10点50分
 */

@Scope("singleton")
@Controller(value = "employeeController")
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    EmployeeMapper employeeMapper;

    /**
     * 列出所有的员工
     */
    @RequestMapping(value = "/allEmployee")
    public String allEmployee(Model model) {
        List<Employee> employees = employeeMapper.getEmployeeAll();       //从数据库中查得所有员工信息
        employees.forEach((v) -> System.out.println(v));
        model.addAttribute("employees", employees);
        return "emp/emplist";
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping(value = "/toAddEmp")
    public String toAddEmp() {
        return "emp/addemp";
    }

}
