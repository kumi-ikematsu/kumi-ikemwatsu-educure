import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProduct {

    public static void update(Connection conn, int newPrice, int productId) {

        try {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
