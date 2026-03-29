import java.sql.Connection;
import java.sql.DriverManager;

public class ProductMaintenance {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/educure_db";
            String user = "postgres";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            // ▼処理呼び出し（必要に応じて変更OK）
            InsertProduct.insert(conn, "サンプル商品", 1000, 10);
            UpdateProduct.update(conn, 2000, 1);
            UpdateStock.updateStock(conn, 5, 1);
            SearchProduct.search(conn, 1);

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
