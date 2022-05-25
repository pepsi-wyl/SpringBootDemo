package com.wyl.mapper;

/**
 * @author by wyl
 * @date 2021/11/21.15点47分
 */

import com.wyl.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部员Mapper接口
 */

@Mapper
@Repository(value = "employeeMapper")
public interface EmployeeMapper {

    /**
     * 查询全部部员信息
     */
    List<Employee> getEmployeeAll();

    /**
     * 删除员工
     */
    void deleteById(Integer id);

    /**
     * 查询部员信息ById
     */
    Employee getEmployeeById(Integer id);

    /**
     * 添加部员信息
     */
    void saveEmployee(Employee employee);

}
