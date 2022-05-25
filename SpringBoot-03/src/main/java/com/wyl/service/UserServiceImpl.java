package com.wyl.service;

/**
 * @author by wyl
 * @date 2021/11/23.
 */

import com.wyl.mapper.UserMapper;

import javax.annotation.Resource;

/**
 * UserServiceIMpl实现类
 */

public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

}
