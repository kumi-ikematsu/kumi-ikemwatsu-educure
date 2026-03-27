import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchProduct {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/your_db";
        String user = "your_username";
        String password = "your_password";

        String query = "SELECT product_name, price FROM products WHERE price >= ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, 100000);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("商品名: " + rs.getString("product_name") + ", 価格: " + rs.getInt("price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
