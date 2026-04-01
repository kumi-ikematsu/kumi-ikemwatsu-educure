package com.example.vocab;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordManager {

    private DBManager dbManager;

    public WordManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addWord(Word word) {
        String sql = "INSERT INTO words (english, japanese) VALUES (?, ?)";
        try (PreparedStatement ps = dbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, word.getEnglish());
            ps.setString(2, word.getJapanese());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("登録エラー: " + e.getMessage());
        }
    }

    public List<Word> getWords() {
        List<Word> list = new ArrayList<>();
        String sql = "SELECT english, japanese FROM words";
        try (Statement st = dbManager.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Word(rs.getString("english"), rs.getString("japanese")));
            }
        } catch (SQLException e) {
            System.err.println("取得エラー: " + e.getMessage());
        }
        return list;
    }

    public int getWordCount() {
        String sql = "SELECT COUNT(*) FROM words";
        try (Statement st = dbManager.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("件数取得エラー: " + e.getMessage());
        }
        return 0;
    }

    public void deleteWord(String english) {
        String sql = "DELETE FROM words WHERE english = ?";
        try (PreparedStatement ps = dbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, english);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("削除エラー: " + e.getMessage());
        }
    }

    public void updateWord(String english, String newJapanese) {
        String sql = "UPDATE words SET japanese = ? WHERE english = ?";
        try (PreparedStatement ps = dbManager.getConnection().prepareStatement(sql)) {
            ps.setString(1, newJapanese);
            ps.setString(2, english);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("更新エラー: " + e.getMessage());
        }
    }
}
