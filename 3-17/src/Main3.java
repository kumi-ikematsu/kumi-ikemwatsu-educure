public class Main3 {
    public static void main(String[] args) {

        Product product = new Product("りんご", 100);

        System.out.println("商品名: " + product.getName());
        System.out.println("在庫数: " + product.getStock());

        product.removeStock(50);

        System.out.println("商品名: " + product.getName());
        System.out.println("在庫数: " + product.getStock());

        product.addStock(10);

        System.out.println("商品名: " + product.getName());
        System.out.println("在庫数: " + product.getStock());

        product.removeStock(200); // 在庫不足テスト
    }
}