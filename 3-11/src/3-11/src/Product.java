public abstract class Product {

    protected String name;
    protected int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 抽象メソッド
    public abstract void displayInfo();

    public abstract void checkStock();
}