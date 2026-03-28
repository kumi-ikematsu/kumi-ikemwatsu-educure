Connection conn = null;

try {
    conn = DriverManager.getConnection(url, user, password);
    conn.setAutoCommit(false);

    // 処理（INSERT / UPDATEなど）
    // 例
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
            conn.rollback(); // ← これ重要🔥
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    e.printStackTrace();

} finally {
    try {
        if (conn != null) {
            conn.close(); // ← これも必須🔥
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
