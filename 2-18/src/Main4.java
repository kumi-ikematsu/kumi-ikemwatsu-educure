public class Main4 {

    public static void main(String[] args) {

        int[] prices = {100, 200, 300};
        int[] quantities = {1, 2, 3};

        int[] totals = calculateTotals(prices, quantities);

        // カンマ区切り表示
        System.out.print("商品価格：");
        printArray(prices);

        System.out.print("数量：");
        printArray(quantities);

        System.out.print("合計金額（税込）：");
        printArray(totals);
    }

    public static int[] calculateTotals(int[] prices, int[] quantities) {

        int length = Math.min(prices.length, quantities.length);
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int subtotal = prices[i] * quantities[i];
            result[i] = (int)(subtotal * 1.1);
        }

        return result;
    }

    // カンマ区切り表示用メソッド
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
