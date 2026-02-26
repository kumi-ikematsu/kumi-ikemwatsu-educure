public class Product {

    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("商品名: " + name);
        System.out.println("価格: " + price + "円");
    }
}