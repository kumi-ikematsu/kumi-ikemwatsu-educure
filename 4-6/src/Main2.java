import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {

        ArrayList<Integer> scores = new ArrayList<>();

        // 点数追加
        scores.add(85);
        scores.add(92);
        scores.add(78);
        scores.add(55);
        scores.add(43);

        System.out.println("点数リスト: " + scores);

        // 平均
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = (double) sum / scores.size();
        System.out.println("平均点: " + average);

        // 最高点
        int max = scores.get(0);
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        System.out.println("最高点: " + max);

        // 不合格者（60点以下）
        int failCount = 0;
        for (int score : scores) {
            if (score <= 60) {
                failCount++;
            }
        }
        System.out.println("不合格者数: " + failCount);
    }
}