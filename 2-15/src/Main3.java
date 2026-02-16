public class Main3 {
    public static void main(String[] args) {

        String[] days = {"月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日"};
        double[] temperatures = {25.5, 26.0, 24.5, 26.5, 27.0, 25.0, 24.0};

        // 各曜日の気温を表示
        for (int i = 0; i < temperatures.length; i++) {
            System.out.println(days[i] + "：" + temperatures[i] + "度");
        }

        // 平均は拡張forで計算
        double total = 0;
        for (double temp : temperatures) {
            total += temp;
        }

        double average = total / temperatures.length;
        System.out.println("平均気温：" + average + "度");
    }
}
