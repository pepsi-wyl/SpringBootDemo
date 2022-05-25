package com.wyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author by wyl
 * @date 2021/11/20.16点26分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableConfigurationProperties

@Alias("user")
@Component(value = "user")
public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private int status;       //权限  管理员0  用户1  状态  -1(封号)
}
