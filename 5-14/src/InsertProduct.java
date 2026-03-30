import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertProduct {

    // DB接続情報（自分の環境に合わせて変更）
    private static final String URL = "jdbc:postgresql://localhost:5432/educure_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // DB接続
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // ★ 要件通りのカラム名
            String sql = "INSERT INTO products (product_name, price, stock) VALUES (?, ?, ?)";

            pstmt = conn.prepareStatement(sql);

            // ★ 要件通りのデータに修正
            pstmt.setString(1, "スマートフォン");
            pstmt.setInt(2, 80000);
            pstmt.setInt(3, 30);

            // SQL実行
            int result = pstmt.executeUpdate();

            // 更新件数チェック
            if (result == 1) {
                System.out.println("商品情報の登録が完了しました。");
            } else {
                System.out.println("商品情報の登録に失敗しました。");
            }

        } catch (SQLException e) {
            System.out.println("データベース処理中にエラーが発生しました。");
            e.printStackTrace();
        } finally {
            // リソース解放
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
