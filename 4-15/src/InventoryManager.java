import java.util.*;

public class InventoryManager {

    private Map<String, Product> inventory = new HashMap<>();

    public void addProduct(String name, int stock) {
        Product product = new Product(name, stock);
        inventory.put(name, product);
    }

    private Optional<Product> findProduct(String name) {
        return Optional.ofNullable(inventory.get(name));
    }

    public void sellProduct(String name) {

        Optional<Product> product = findProduct(name);

        if (product.isPresent()) {

            Product p = product.get();

            if (p.getStock() > 0) {
                p.decreaseStock();
                System.out.println(name + "を購入しました");
            } else {
                System.out.println(name + "は在庫切れです");
            }

        } else {
            System.out.println("商品が見つかりません");
        }
    }
}