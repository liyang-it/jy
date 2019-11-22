package com.jy.mapper;

import com.jy.entity.wordText;

import java.util.List;

public interface wordTextMapper {
    List<wordText> queryWordtextPage(wordText wd);
    int getRowsCount();
    void insertWordText(wordText wd);
    int deleteWordTextById(int wordid);
    wordText selectWordTextById(int wordid);
    int selectWordTextCount();

}