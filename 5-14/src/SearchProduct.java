import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchProduct {

    public static void search(Connection conn, int productId) {

        try {
            String sql = "SELECT * FROM products WHERE product_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("商品ID: " + rs.getInt("product_id"));
                System.out.println("商品名: " + rs.getString("name"));
                System.out.println("価格: " + rs.getInt("price"));
                System.out.println("在庫: " + rs.getInt("stock"));
            } else {
                System.out.println("商品が見つかりませんでした。");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
