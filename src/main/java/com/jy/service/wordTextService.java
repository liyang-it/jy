package com.jy.service;

import com.jy.entity.wordText;

import java.util.List;

public interface wordTextService {
    List<wordText> queryWordtextPage(wordText wd);
    int getRowsCount();
    void insertWordText(wordText wd);
    int deleteWordTextById(int wordid);
    wordText selectWordTextById(int wordid);
    int selectWordTextCount();
}
