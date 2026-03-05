import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {

        // 学生の名前を管理するArrayList
        ArrayList<String> students = new ArrayList<>();

        // 学生を追加
        students.add("田中");
        students.add("佐藤");
        students.add("鈴木");

        // 学生リスト表示
        System.out.println("学生リスト: " + students);

        // 2番目の学生
        System.out.println("2番目の学生: " + students.get(1));

        // 学生数
        System.out.println("学生数: " + students.size());

        // 鈴木が含まれているか
        System.out.println("鈴木さんは含まれていますか？: " + students.contains("鈴木"));
    }
}