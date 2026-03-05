import java.util.HashMap;

public class Main3 {
    public static void main(String[] args) {

        // 商品と在庫を管理するHashMap
        HashMap<String, Integer> stock = new HashMap<>();

        // 商品を追加
        stock.put("おにぎり", 15);
        stock.put("サンドイッチ", 8);
        stock.put("お弁当", 5);

        // 在庫表示
        System.out.println("在庫状況: " + stock);

        // おにぎりを1個販売
        int onigiriStock = stock.get("おにぎり");
        stock.put("おにぎり", onigiriStock - 1);

        System.out.println("おにぎりを1個販売しました");

        // 更新後の在庫
        System.out.println("在庫状況: " + stock);

        // アイスクリームがあるか確認
        System.out.println("アイスクリームは在庫がありますか？: " + stock.containsKey("アイスクリーム"));
    }
}