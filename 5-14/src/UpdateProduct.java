import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateProduct {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "password";

        String updatePriceSql =
                "UPDATE products SET price = price - 5000 WHERE product_name = ?";
        String updateStockSql =
                "UPDATE products SET stock = stock + 5 WHERE price < 50000";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt1 = conn.prepareStatement(updatePriceSql);
             PreparedStatement pstmt2 = conn.prepareStatement(updateStockSql)) {

            // ①タブレット値下げ
            pstmt1.setString(1, "タブレット");
            int priceCount = pstmt1.executeUpdate();
            System.out.println("価格を値下げした行数：" + priceCount);

            // ②在庫増加
            int stockCount = pstmt2.executeUpdate();
            System.out.println("在庫を増やした行数：" + stockCount);

        } catch (Exception e) {
            System.out.println("エラーが発生しました。");
            e.printStackTrace();
        }
    }
}
