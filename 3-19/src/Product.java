public class Product {

    String name;
    int price;

    // コンストラクタ
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // toStringオーバーライド
    @Override
    public String toString() {
        return "商品名：" + name + "（" + price + "円）";
    }
}