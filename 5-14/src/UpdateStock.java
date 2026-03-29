import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateStock {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/your_db";
        String user = "your_username";
        String password = "your_password";

        String checkStockSQL = "SELECT COUNT(*) FROM products WHERE stock > 0";
        String updateSQL = "UPDATE products SET stock = CASE WHEN stock < 10 THEN 0 ELSE stock - 10 END WHERE stock > 0";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // 在庫が全て0か確認
            PreparedStatement checkStmt = conn.prepareStatement(checkStockSQL);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("エラー: 在庫を更新できる商品がありません。");
                return;
            }

            PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
            updateStmt.executeUpdate();
            System.out.println("在庫が正常に更新されました。");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}