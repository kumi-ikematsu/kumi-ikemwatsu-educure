import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertProduct {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/educure_db";
            String user = "postgres";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "テスト商品");
            pstmt.setInt(2, 1000);
            pstmt.setInt(3, 10);

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
