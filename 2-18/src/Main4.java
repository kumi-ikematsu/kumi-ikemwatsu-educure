import java.util.Arrays;

public class Main4 {

    public static void main(String[] args) {

        int[] prices = {100, 200, 300};      // 商品価格
        int[] quantities = {1, 2, 3};        // 数量

        int[] totals = calculateTotals(prices, quantities);

        System.out.println("商品価格：" + Arrays.toString(prices));
        System.out.println("数量：" + Arrays.toString(quantities));
        System.out.println("合計金額（税込）：" + Arrays.toString(totals));
    }

    // 各商品の税込み合計を計算するメソッド
    public static int[] calculateTotals(int[] prices, int[] quantities) {

        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int subtotal = prices[i] * quantities[i];
            result[i] = (int)(subtotal * 1.1);  // 消費税10%
        }

        return result;
    }
}
