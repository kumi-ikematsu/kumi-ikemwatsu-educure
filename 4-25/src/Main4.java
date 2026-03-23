import java.util.*;
import java.util.stream.*;

public class Main4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int result = numbers.stream()         // Streamを作成
                            .filter(n -> n % 2 == 0)  // 偶数のみを抽出
                            .mapToInt(n -> n * 2)     // 各要素を2倍に変換
                            .sum();                   // 合計を計算

        System.out.println("結果: " + result);
    }
}
