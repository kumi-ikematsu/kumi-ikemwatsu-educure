import java.util.*;
import java.util.stream.*;

public class Main2 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // ここがポイント
        List<String> result = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
