package com.jy.service;

import com.jy.entity.dict;
import java.util.List;

public interface dictService {
    List<dict> queryDictByKey(String type);
    int insertNames(String value);
    int insertLinkType(String value);
    int deleteDictById(int id);



}
