package com.example.vocab;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VocabularyDAO {

    public void insert(String word, String meaning) {

        String sql = "INSERT INTO vocabulary(word, meaning) VALUES (?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, word);
            ps.setString(2, meaning);

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println("登録成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vocabulary> findAll() {

        List<Vocabulary> list = new ArrayList<>();
        String sql = "SELECT * FROM vocabulary";

        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Vocabulary(
                        rs.getInt("id"),
                        rs.getString("word"),
                        rs.getString("meaning")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void update(int id, String meaning) {

        String sql = "UPDATE vocabulary SET meaning=? WHERE id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, meaning);
            ps.setInt(2, id);

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("該当データなし");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM vocabulary WHERE id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int count = ps.executeUpdate();

            if (count > 0) {
                System.out.println("削除成功");
            } else {
                System.out.println("該当データなし");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
