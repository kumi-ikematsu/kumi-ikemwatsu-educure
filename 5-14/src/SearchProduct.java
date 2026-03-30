import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchProduct {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/educure_db";
            String user = "postgres";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);

            int productId = 1;

            String sql = "SELECT * FROM products WHERE product_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("商品ID: " + rs.getInt("product_id"));
                System.out.println("商品名: " + rs.getString("name"));
                System.out.println("価格: " + rs.getInt("price"));
                System.out.println("在庫: " + rs.getInt("stock"));
            } else {
                System.out.println("商品が見つかりませんでした。");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
