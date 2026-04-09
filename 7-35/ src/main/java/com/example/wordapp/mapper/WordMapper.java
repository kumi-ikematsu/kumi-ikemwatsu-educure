package com.example.wordapp.mapper;

import com.example.wordapp.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface WordMapper {

    // 単語を1件登録する
    void insertWord(Word word);

    // 全件取得
    List<Word> findAll();

    // IDで1件取得
    Word findById(int id);

    // 単語を更新する
    void updateWord(Word word);

    // IDで削除する
    void deleteWord(int id);
}
