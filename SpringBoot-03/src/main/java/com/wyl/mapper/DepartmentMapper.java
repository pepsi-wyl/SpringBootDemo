package com.wyl.mapper;

/**
 * @author by wyl
 * @date 2021/11/21.15点47分
 */

import com.wyl.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * 部门Mapper接口
 */
@Mapper
@Repository(value = "departmentMapper")
public interface DepartmentMapper {

    /**
     * 查询所有部门信息
     */
    Collection<Department> getDepartments();

    /**
     * 通过id查询信息
     */
    Department getDepartmentById(Integer id);


}
