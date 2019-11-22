package com.jy.mapper;

import com.jy.entity.user;

import java.util.List;

public interface userMapper {
    user queryUserByNameAndPasswd(user user);
    List<user> queryUserAll(user user);

}