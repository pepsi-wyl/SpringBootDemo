package com.wyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author by wyl
 * @date 2021/11/21.15点37分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Alias("employee")
@Component(value = "employee")
public class Employee {
    private int id;     //ID
    private String empNumber;   //员工编号
    private String name;    //姓名
    private String sex;     //性别
    private String email;   //邮箱
    private String phoneNumber;  //电话号码
    private Date birth;          //生日
    private String location;     //地址
    private Department department;  //部门
}
