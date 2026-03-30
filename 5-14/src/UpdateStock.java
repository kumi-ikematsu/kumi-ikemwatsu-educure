import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateStock {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "password";

        String checkSql = "SELECT COUNT(*) FROM products WHERE stock > 0";
        String updateSql =
                "UPDATE products SET stock = CASE WHEN stock >= 10 THEN stock - 10 ELSE 0 END";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement checkStmt = conn.prepareStatement(checkSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {

            // 在庫がすべて0か確認
            try (ResultSet rs = checkStmt.executeQuery()) {
                rs.next();
                int count = rs.getInt(1);

                if (count == 0) {
                    System.out.println("更新対象の商品がありません。");
                    return;
                }
            }

            int result = updateStmt.executeUpdate();

            if (result > 0) {
                System.out.println("在庫が正常に更新されました。");
            }

        } catch (Exception e) {
            System.out.println("エラーが発生しました。");
            e.printStackTrace();
        }
    }
}
