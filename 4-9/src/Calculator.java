public class Calculator {

    // 2つの整数の割り算を行うメソッド
    public int divide(int a, int b) throws Exception {

        if (b == 0) {
            throw new Exception("エラー：0で割ることはできません");
        }

        return a / b;
    }
}