public class Product {

    private String name;
    private int stock;

    // コンストラクタ
    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    // 在庫追加
    public void addStock(int amount) {
        if (amount > 0) {
            stock += amount;
            System.out.println(amount + "個追加しました");
        } else {
            System.out.println("エラー：正の数を入力してください");
        }
    }

    // 在庫減少
    public void removeStock(int amount) {
        if (amount <= 0) {
            System.out.println("エラー：正の数を入力してください");
        } else if (amount > stock) {
            System.out.println("エラー：在庫が不足しています");
        } else {
            stock -= amount;
            System.out.println(amount + "個販売しました");
        }
    }
}