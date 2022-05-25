package com.wyl.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * @author by wyl
 * @date 2021/11/21.15点32分
 * 部门表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Alias("department")  //起别名
@Component(value = "department")
public class Department {
    private Integer id;
    private String department;
}
