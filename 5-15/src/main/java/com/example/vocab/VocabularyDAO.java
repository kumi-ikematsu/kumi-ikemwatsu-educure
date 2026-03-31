package com.example.vocab;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VocabularyDAO {

    private Connection con;

    public VocabularyDAO(Connection con) {
        this.con = con;
    }

    public int insert(String word, String meaning) throws SQLException {

        String sql = "INSERT INTO vocabulary(word, meaning) VALUES (?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, word);
        ps.setString(2, meaning);

        return ps.executeUpdate();
    }

    public List<Vocabulary> findAll() throws SQLException {

        List<Vocabulary> list = new ArrayList<>();
        String sql = "SELECT * FROM vocabulary";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            list.add(new Vocabulary(
                    rs.getString("word"),
                    rs.getString("meaning")
            ));
        }

        return list;
    }

    public int update(String word, String meaning) throws SQLException {

        String sql = "UPDATE vocabulary SET meaning=? WHERE word=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, meaning);
        ps.setString(2, word);

        return ps.executeUpdate();
    }

    public int delete(String word) throws SQLException {

        String sql = "DELETE FROM vocabulary WHERE word=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, word);

        return ps.executeUpdate();
    }
}
