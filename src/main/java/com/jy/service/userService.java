package com.jy.service;

import com.jy.entity.user;
import org.springframework.stereotype.Service;

import java.util.List;


public interface userService {
    user queryUserByNameAndPasswd(user user);
    List<user> queryUserAll(user user);
}
