package com.jy.mapper;

import com.jy.entity.link;

import java.util.List;

public interface linkMapper {
    List<link> queryLinkByLinkType(String type);

}