import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "date", "cherry", "elderberry");

        // Stream APIを使用した処理
        List<String> result = words.stream()
            .filter(s -> s.length() >= 5) // 5文字以上で絞り込み
            .sorted()                    // アルファベット順にソート
            .collect(Collectors.toList()); // リストに変換

        // 結果の出力
        System.out.println(result);
    }
}