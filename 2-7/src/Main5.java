package src;

public class Main5 {
    public static void main(String[] args) {

        // 商品の価格と個数
        int notePrice = 280;
        int noteCount = 3;

        int pencilPrice = 120;
        int pencilCount = 5;

        int eraserPrice = 100;
        int eraserCount = 2;

        // 小計を計算
        int subtotal = notePrice * noteCount
                     + pencilPrice * pencilCount
                     + eraserPrice * eraserCount;

        // 消費税（10%・切り捨て）
        int tax = (int)(subtotal * 0.1);

        // 合計金額
        int total = subtotal + tax;

        // おつり（2000円支払い）
        int change = 2000 - total;
    
        System.out.println("小計：" + subtotal + "円");
        System.out.println("消費税：" + tax + "円");
        System.out.println("合計金額：" + total + "円");
        System.out.println("おつり：" + change + "円");
    }
}
