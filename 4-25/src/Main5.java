public class Main5 {
    public static void main(String[] args) {
        int input = 8;

        // 順番に関数を適用
        int multiplied = multiplyByTwo(input);
        int subtracted = subtractFive(multiplied);
        boolean result = isPositive(subtracted);

        // 結果の判定と出力
        if (result) {
            System.out.println("正の数です");
        } else {
            System.out.println("負の数またはゼロです");
        }
    }

    // 2倍にする関数
    public static int multiplyByTwo(int n) {
        return n * 2;
    }

    // 5を引く関数
    public static int subtractFive(int n) {
        return n - 5;
    }

    // 正の数か判定する関数
    public static boolean isPositive(int n) {
        return n > 0;
    }
}