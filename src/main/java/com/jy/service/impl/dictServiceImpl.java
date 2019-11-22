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
    public List<dict> queryDictByKey(String type) {
        return mapper.queryDictByKey(type);
    }

    @Override
    public int insertNames(String value) {
        return mapper.insertNames(value);
    }

    @Override
    public int deleteDictById(int id) {
        return mapper.deleteDictById(id);
    }

    @Override
    public int insertLinkType(String value) {
        return mapper.insertLinkType(value);
    }
}
