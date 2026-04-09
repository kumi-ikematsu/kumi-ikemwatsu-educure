package jp.educure.webapp.service.impl;

import jp.educure.webapp.entity.Word;
import jp.educure.webapp.repository.WordMapper;
import jp.educure.webapp.service.WordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WordServiceImpl implements WordService {

    private final WordMapper wordMapper;

    public WordServiceImpl(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Word> findAll() {
        return wordMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Word findById(Integer id) {
        return wordMapper.findById(id);
    }

    @Override
    public void save(Word word) {
        wordMapper.insert(word);
    }

    @Override
    public void update(Word word) {
        wordMapper.update(word);
    }

    @Override
    public void delete(Integer id) {
        wordMapper.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public int count() {
        return wordMapper.count();
    }
}
