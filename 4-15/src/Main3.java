public class Main3 {

    public static void main(String[] args) {

        Inventory<String> fruits = new Inventory<>(ProductCategory.FRUITS);
        Inventory<String> vegetables = new Inventory<>(ProductCategory.VEGETABLES);
        Inventory<String> dairy = new Inventory<>(ProductCategory.DAIRY);

        fruits.stock("りんご");
        vegetables.stock("トマト");
        dairy.stock("牛乳");

        System.out.println();

        fruits.stockOut();
        System.out.println("りんごを出荷しました");

        System.out.println("現在の在庫状態:");
        System.out.println("果物: " + (fruits.getCurrentStock() == null ? "なし" : fruits.getCurrentStock()));
        System.out.println("野菜: " + (vegetables.getCurrentStock() == null ? "トマト" : vegetables.getCurrentStock()));
        System.out.println("乳製品: " + (dairy.getCurrentStock() == null ? "牛乳" : dairy.getCurrentStock()));
    }
}