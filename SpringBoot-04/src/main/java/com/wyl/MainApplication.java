package com.wyl;

import com.wyl.mapper.JDBC;
import com.wyl.mapper.JDBCTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        run.getBean("jdbc", JDBC.class).showConnectionInfo();
//        System.out.println(run.getBean("jdbcTemplateUser", JDBCTemplate.class).getUserList());
    }

}
