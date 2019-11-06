package com.jy.service;

import com.jy.entity.link;
import com.jy.entity.wordText;

import java.util.List;

public interface linkService {
    List<link> queryLinkByLinkType(String type);
}
