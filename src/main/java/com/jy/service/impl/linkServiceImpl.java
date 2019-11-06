package com.jy.service.impl;

import com.jy.entity.link;
import com.jy.mapper.linkMapper;
import com.jy.service.linkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class linkServiceImpl  implements linkService {
    @Autowired
    private linkMapper mapper;
    @Override
    public List<link> queryLinkByLinkType(String type) {
        return mapper.queryLinkByLinkType(type);
    }
}
