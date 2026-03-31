package com.example.vocab;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VocabularyService {

    private VocabularyDAO dao;

    public VocabularyService(Connection con) {
        this.dao = new VocabularyDAO(con);
    }

    public boolean add(String word, String meaning) throws SQLException {
        return dao.insert(word, meaning) > 0;
    }

    public List<Vocabulary> getAll() throws SQLException {
        return dao.findAll();
    }

    public boolean update(String word, String meaning) throws SQLException {
        return dao.update(word, meaning) > 0;
    }

    public boolean delete(String word) throws SQLException {
        return dao.delete(word) > 0;
    }
}
