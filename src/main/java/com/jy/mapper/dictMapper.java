package com.jy.mapper;

import com.jy.entity.dict;

import java.util.List;

public interface dictMapper {
    List<dict> queryDictByKey(String type);
    int insertNames(String value);
    int insertLinkType(String value);
    int deleteDictById(int id);
}
