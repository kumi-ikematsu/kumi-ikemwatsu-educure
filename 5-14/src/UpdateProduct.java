import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateProduct {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/educure_db";
            String user = "postgres";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            int newPrice = 2000;
            int productId = 1;

            String sql = "UPDATE products SET price = ? WHERE product_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newPrice);
            pstmt.setInt(2, productId);

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
