import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertProduct {

    public static void insert(Connection conn, String name, int price, int stock) {

        try {
            String sql = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, stock);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("商品登録が完了しました。");
            } else {
                System.out.println("商品登録に失敗しました。");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}