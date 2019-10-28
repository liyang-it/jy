package com.jy.service.impl;

import com.jy.entity.dict;
import com.jy.mapper.dictMapper;
import com.jy.service.dictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dictServiceImpl implements dictService {
    @Autowired
    private dictMapper mapper;
    @Override
    public List<dict> queryDict() {
        return mapper.queryDict();
    }
}
