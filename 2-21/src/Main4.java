import java.util.ArrayList;
import java.util.Collections;

public class Main4 {

    public static void processNumbers(int[] numbers) {

        // 配列 → ArrayList に変換
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : numbers) {
            list.add(num);
        }

        // 元のリスト表示
        System.out.println("元のリスト: " + list);

        // ソート
        Collections.sort(list);
        System.out.println("ソート後: " + list);

        // 最大値・最小値
        int max = Collections.max(list);
        int min = Collections.min(list);

        System.out.println("最大値: " + max);
        System.out.println("最小値: " + min);
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9};
        processNumbers(numbers);
    }
}
