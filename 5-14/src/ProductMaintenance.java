import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductMaintenance {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/educure_db";
            String user = "postgres";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            // 商品登録（INSERT）
            String insertSql = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, "サンプル商品");
            insertStmt.setInt(2, 1000);
            insertStmt.setInt(3, 10);
            int insertResult = insertStmt.executeUpdate();
            if (insertResult > 0) {
                System.out.println("商品登録が完了しました。");
            } else {
                System.out.println("商品登録に失敗しました。");
            }

            // 価格更新（UPDATE）
            String updateSql = "UPDATE products SET price = ? WHERE product_id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setInt(1, 2000);
            updateStmt.setInt(2, 1);
            int updateResult = updateStmt.executeUpdate();
            if (updateResult > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("対象データなし");
            }

            // 在庫更新（UPDATE）
            String stockSql = "UPDATE products SET stock = stock + ? WHERE product_id = ?";
            PreparedStatement stockStmt = conn.prepareStatement(stockSql);
            stockStmt.setInt(1, 5);
            stockStmt.setInt(2, 1);
            int stockResult = stockStmt.executeUpdate();
            if (stockResult > 0) {
                System.out.println("在庫更新が完了しました。");
            } else {
                System.out.println("該当する商品が見つかりませんでした。");
            }

            // 商品検索（SELECT）
            String searchSql = "SELECT * FROM products WHERE product_id = ?";
            PreparedStatement searchStmt = conn.prepareStatement(searchSql);
            searchStmt.setInt(1, 1);
            ResultSet rs = searchStmt.executeQuery();
            if (rs.next()) {
                System.out.println("商品ID: " + rs.getInt("product_id"));
                System.out.println("商品名: " + rs.getString("name"));
                System.out.println("価格: " + rs.getInt("price"));
                System.out.println("在庫: " + rs.getInt("stock"));
            } else {
                System.out.println("商品が見つかりませんでした。");
            }

            conn.commit();

        } catch (Exception e) {

            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

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
