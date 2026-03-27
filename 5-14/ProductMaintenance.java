import java.sql.*;

public class ProductMaintenance {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/your_db";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);

            // 1. 在庫数0の商品の価格を0に設定
            String sql1 = "UPDATE products SET price = 0 WHERE stock = 0";
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            int rows1 = stmt1.executeUpdate();
            System.out.println("影響を受けた行数（在庫数0の商品価格を0に設定）: " + rows1);

            // 2. 価格が200000以上の商品を削除
            String sql2 = "DELETE FROM products WHERE price >= 200000";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            int rows2 = stmt2.executeUpdate();
            System.out.println("影響を受けた行数（価格が200000以上の商品削除）: " + rows2);

            // 3. 価格100000以上で在庫10以下の商品を在庫20に更新
            String sql3 = "UPDATE products SET stock = 20 WHERE price >= 100000 AND stock <= 10";
            PreparedStatement stmt3 = conn.prepareStatement(sql3);
            int rows3 = stmt3.executeUpdate();
            System.out.println("影響を受けた行数（価格100000以上、在庫数10以下の商品を在庫数20に更新）: " + rows3);

            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
