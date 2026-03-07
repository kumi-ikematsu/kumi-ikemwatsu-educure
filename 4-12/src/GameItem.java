public class GameItem {

    private String name;
    private int price;

    // コンストラクタ
    public GameItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // toStringメソッドをオーバーライド
    @Override
    public String toString() {
        return "[" + name + "] 価格: " + price + "G";
    }
}