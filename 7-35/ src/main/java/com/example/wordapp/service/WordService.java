package com.example.wordapp.service;

import com.example.wordapp.entity.Word;
import com.example.wordapp.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WordService {

    @Autowired
    WordMapper wordMapper;

    // 単語を登録する
    public void registerWord(Word word) {
        wordMapper.insertWord(word);
    }

    // 全件取得
    public List<Word> getAllWords() {
        return wordMapper.findAll();
    }

    // IDで1件取得
    public Word getWordById(int id) {
        return wordMapper.findById(id);
    }

    // 単語を更新する
    public void updateWord(Word word) {
        wordMapper.updateWord(word);
    }

    // 単語を削除する
    public void deleteWord(int id) {
        wordMapper.deleteWord(id);
    }
}
