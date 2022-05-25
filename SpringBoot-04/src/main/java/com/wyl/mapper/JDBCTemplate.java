package com.wyl.mapper;


import com.wyl.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/11/22.14点40分
 */

@Component(value = "jdbcTemplateUser")
public class JDBCTemplate {

    @Resource          //JdbcTemplate需要注入DataSource
    JdbcTemplate jdbcTemplate;

    /**
     * 查询所有用户
     */
    public List<User> getUserList() {
        return jdbcTemplate.query("select * from springboot.user", new BeanPropertyRowMapper<User>(User.class));
    }

}
