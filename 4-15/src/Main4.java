public class Main4 {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        manager.addProduct("バナナ", 5);

        manager.sellProduct("バナナ");

        manager.sellProduct("りんご");
    }
}