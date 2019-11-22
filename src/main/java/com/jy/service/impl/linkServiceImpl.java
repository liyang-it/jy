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
    public List<link> queryLinkByLinkType(link link) {
        return mapper.queryLinkByLinkType(link);
    }

    public void setMapper(linkMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int deleteLinkById(int id) {
        return mapper.deleteLinkById(id);
    }

    @Override
    public int updateLink(link link) {
        return mapper.updateLink(link);
    }

    @Override
    public link selectLinkById(int id) {
        return mapper.selectLinkById(id);
    }

    @Override
    public List<link> queryLinkByLinkTypeAll(String type) {
        return mapper.queryLinkByLinkTypeAll(type);
    }

    @Override
    public int selectLinkCount() {
        return mapper.selectLinkCount();
    }
}
