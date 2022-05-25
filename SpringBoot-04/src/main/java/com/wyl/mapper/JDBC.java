package com.wyl.mapper;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

/**
 * @author by wyl
 * @date 2021/11/22.14点30分
 */

/**
 * 原生JDBC操作
 */

/**
 * 可以编写很多原生的JDBC代码
 */
@Component(value = "jdbc")
public class JDBC {

    @Resource      //注入数据源
    DataSource dataSource;

    @SneakyThrows
    public void showConnectionInfo() {
        Connection connection = dataSource.getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        System.out.println("连接>>>>>>>>" + connection);
        System.out.println("连接地址>>>>" + metaData.getURL());
        System.out.println("驱动名称>>>>" + metaData.getDriverName());
        System.out.println("驱动版本>>>>" + metaData.getDriverVersion());
        System.out.println("数据库名称>>" + metaData.getDatabaseProductName());
        System.out.println("数据库版本>>" + metaData.getDatabaseProductVersion());
        System.out.println("连接用户名称>" + metaData.getUserName());
        connection.close();
    }

}
