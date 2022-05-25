package com.wyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

@Component(value = "user")
public class User {
    private int id;
    private String userName;
    private String password;
}
