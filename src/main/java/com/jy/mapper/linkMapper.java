package com.jy.mapper;

import com.jy.entity.link;

import java.util.List;

public interface linkMapper {
    List<link> queryLinkByLinkType(link link);
    List<link> queryLinkByLinkTypeAll(String type);
    int deleteLinkById(int id);
    int updateLink(link link);
    link selectLinkById(int id);
    int selectLinkCount();

}