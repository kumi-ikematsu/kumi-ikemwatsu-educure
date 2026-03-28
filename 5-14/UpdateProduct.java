String sql = "UPDATE products SET stock = stock + ? WHERE product_id = ?";

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, addStock);
pstmt.setInt(2, productId);

int result = pstmt.executeUpdate();

if (result > 0) {
    System.out.println("在庫更新が完了しました。");
} else {
    System.out.println("該当する商品が見つかりませんでした。");
}
