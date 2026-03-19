public class Divider {
    /**
     * 2つの数値を割り算します。
     * @param num1 被除数
     * @param num2 除数
     * @return 割り算の結果（小数）
     * @throws ArithmeticException 0で割ろうとした場合
     */
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            // 指摘通りのメッセージをスロー
            throw new ArithmeticException("0で割ることはできません。");
        }
        return num1 / num2;
    }
}
