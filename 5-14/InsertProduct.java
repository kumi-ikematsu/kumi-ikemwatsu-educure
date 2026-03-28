int result = pstmt.executeUpdate();

if (result > 0) {
    System.out.println("商品登録が完了しました。");
} else {
    System.out.println("商品登録に失敗しました。");
}
