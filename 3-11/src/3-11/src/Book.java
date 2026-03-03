public class Book extends Product {

    private String author;
    private int stockQuantity;

    public Book(String name, int price, String author, int stockQuantity) {
        super(name, price);
        this.author = author;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public void displayInfo() {
        System.out.println("書籍名: " + name);
        System.out.println("著者: " + author);
        System.out.println("価格: " + price + "円");
    }

    @Override
    public void checkStock() {
        if (stockQuantity > 0) {
            System.out.println("在庫あり");
        } else {
            System.out.println("在庫なし");
        }
    }
}