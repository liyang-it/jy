package com.jy.service;

import com.jy.entity.link;
import com.jy.entity.wordText;

import java.util.List;

public interface linkService {
    List<link> queryLinkByLinkType(link link);
    List<link> queryLinkByLinkTypeAll(String type);
    int deleteLinkById(int id);
    int updateLink(link link);
    link selectLinkById(int id);
    int selectLinkCount();
}
