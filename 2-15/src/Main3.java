public class Main3 {
    public static void main(String[] args) {
        double[] temperatures = {25.5, 26.0, 24.5, 26.5, 27.0, 25.0, 24.0};
        // ここに平均気温を計算するコードを書いてください
        double total = 0;

        // 拡張for文
        for (double temp : temperatures) {
            total += temp;
        }

        double average = total / temperatures.length;

        System.out.println("平均気温：" + average + "度");
    }
}