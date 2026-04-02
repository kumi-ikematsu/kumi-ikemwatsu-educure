package com.example.vocab;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordManager {

    private DBManager dbManager;

    public WordManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addWord(Word word) throws SQLException {
        String sql = "INSERT INTO words (english, japanese) VALUES (?, ?)";
        try (PreparedStatement ps = dbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, word.getEnglish());
            ps.setString(2, word.getJapanese());
            ps.executeUpdate();
        }
    }

    public List<Word> getWords() throws SQLException {
        List<Word> list = new ArrayList<>();
        String sql = "SELECT english, japanese FROM words";
        try (Statement st = dbManager.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Word(rs.getString("english"), rs.getString("japanese")));
            }
        }
        return list;
    }

    public int getWordCount() throws SQLException {
        String sql = "SELECT COUNT(*) FROM words";
        try (Statement st = dbManager.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public void deleteWord(String english) throws SQLException {
        String sql = "DELETE FROM words WHERE english = ?";
        try (PreparedStatement ps = dbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, english);
            ps.executeUpdate();
        }
    }

    public void updateWord(String english, String newJapanese) throws SQLException {
        String sql = "UPDATE words SET japanese = ? WHERE english = ?";
        try (PreparedStatement ps = dbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, newJapanese);
            ps.setString(2, english);
            ps.executeUpdate();
        }
    }
}
