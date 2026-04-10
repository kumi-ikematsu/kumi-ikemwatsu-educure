package jp.educure.webapp.service;

import jp.educure.webapp.entity.Word;

import java.util.List;

public interface WordService {

    List<Word> findAll();

    Word findById(Integer id);

    void save(Word word);

    boolean update(Word word);

    boolean delete(Integer id);

    int count();
}
