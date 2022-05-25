package com.wyl.mapper;

/**
 * @author by wyl
 * @date 2021/11/23.09点33分
 */


import com.wyl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Mapper接口
 */

@Mapper
@Repository(value = "userMapper")
public interface UserMapper{

    /**
     * 得到用户信息ByUserNameAndPwd  登陆
     */
    User getUserByUserNameAndPwd(User user);

    /**
     * 查询用户是否存在  1 0
     */
    int userIsExit(@Param("username") String userName);

    /**
     * 查询email是否存在 1 0
     */
    int emailIsExit(@Param("email") String email);

    /**
     * 添加用户信息  注册用户
     */
    int adduser(User user);

    /**
     * 更新用户信息  重置密码
     */
    int updateUser(User user);

    /**
     * 得到所有用户信息
     */
    List<User> getUserList();


    /**
     * 删除用户信息
     */
    int deleteUserById(@Param("id") int id);

}


