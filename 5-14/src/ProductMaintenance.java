import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductMaintenance {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/educure_db";
            String user = "postgres";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            String sql = "UPDATE products SET price = ? WHERE product_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1000); // 仮
            pstmt.setInt(2, 1);    // 仮

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("対象データなし");
            }

            conn.commit();

        } catch (Exception e) {

            try {
                if (conn != null) {
                    conn.rollback(); // ←これ良い🔥
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {
                if (conn != null) {
                    conn.close(); // ←これも良い🔥
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}