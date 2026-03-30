import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductMaintenance {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "password";

        String updateZeroStockPrice =
                "UPDATE products SET price = 0 WHERE stock = 0";
        String deleteHighPrice =
                "DELETE FROM products WHERE price >= 200000";
        String updateStockCondition =
                "UPDATE products SET stock = 20 WHERE price >= 100000 AND stock <= 10";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            conn.setAutoCommit(false);

            try (PreparedStatement pstmt1 = conn.prepareStatement(updateZeroStockPrice);
                 PreparedStatement pstmt2 = conn.prepareStatement(deleteHighPrice);
                 PreparedStatement pstmt3 = conn.prepareStatement(updateStockCondition)) {

                // ①在庫0 → 価格0
                int count1 = pstmt1.executeUpdate();
                System.out.println("影響を受けた行数（在庫数0の商品価格を0に設定）： " + count1);

                // ②削除
                int count2 = pstmt2.executeUpdate();
                System.out.println("影響を受けた行数（価格が200000以上の商品削除）： " + count2);

                // ③在庫更新
                int count3 = pstmt3.executeUpdate();
                System.out.println("影響を受けた行数（価格100000以上かつ在庫10以下の商品更新）： " + count3);

                conn.commit();

            } catch (Exception e) {
                conn.rollback();
                throw e;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
