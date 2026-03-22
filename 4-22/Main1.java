import java.io.*;

public class Main1 {

    public static void main(String[] args) {

        String filename = "exercise.csv";

        // CSVファイル作成
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("名前,年齢,職業");
            writer.println("山田,28,プログラマー");
            System.out.println("CSVファイルを作成しました: " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // CSVファイル読み込み
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            br.readLine(); // ヘッダー飛ばし

            String line = br.readLine();
            String[] data = line.split(",");

            for (String item : data) {
                System.out.println(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}