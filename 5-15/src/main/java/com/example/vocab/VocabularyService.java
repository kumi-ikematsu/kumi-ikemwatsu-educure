package com.example.vocab;

import java.util.List;

public class VocabularyService {

    private VocabularyDAO dao = new VocabularyDAO();

    public void add(String word, String meaning) {
        dao.insert(word, meaning);
    }

    public List<Vocabulary> getAll() {
        return dao.findAll();
    }

    public void update(int id, String meaning) {
        dao.update(id, meaning);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
