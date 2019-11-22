package com.jy.service.impl;

import com.jy.entity.wordText;
import com.jy.mapper.wordTextMapper;
import com.jy.service.wordTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordTextServiceImpl implements wordTextService {
    @Autowired
    private wordTextMapper mapper;


    @Override
    public List<wordText> queryWordtextPage(wordText wd) {
        return mapper.queryWordtextPage(wd);
    }

    @Override
    public int getRowsCount() {
        return mapper.getRowsCount();
    }

    @Override
    public void insertWordText(wordText wd) {
        mapper.insertWordText(wd);
    }

    @Override
    public int deleteWordTextById(int wordid) {
        return mapper.deleteWordTextById(wordid);
    }

    @Override
    public wordText selectWordTextById(int wordid) {
        return mapper.selectWordTextById(wordid);
    }

    @Override
    public int selectWordTextCount() {
        return mapper.selectWordTextCount();
    }
}
