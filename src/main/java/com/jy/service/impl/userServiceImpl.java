package com.jy.service.impl;

import com.jy.entity.user;
import com.jy.mapper.userMapper;
import com.jy.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper mapper;

    @Override
    public user queryUserByNameAndPasswd(user user) {
        return mapper.queryUserByNameAndPasswd(user);
    }

    @Override
    public List<user> queryUserAll(user user) {
        return mapper.queryUserAll(user);
    }
}
