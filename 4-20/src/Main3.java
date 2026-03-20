import java.io.File;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) {

        File folder = new File("exercise_folder");

        // ★ 事前チェックあり（ここが修正ポイント）
        if (folder.exists()) {
            System.out.println("フォルダは既に存在します。");
        } else {
            if (folder.mkdir()) {
                System.out.println("フォルダを作成しました。");
            } else {
                System.out.println("フォルダの作成に失敗しました。");
            }
        }

        File file = new File(folder, "exercise_file.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("ファイルを作成しました。");
            } else {
                System.out.println("ファイルは既に存在します。");
            }
        } catch (IOException e) {
            System.out.println("ファイルの作成中にエラーが発生しました。");
        }
    }
}
