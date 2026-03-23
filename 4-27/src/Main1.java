import java.io.*;
import java.net.*;

public class Main1 {
    public static void main(String[] args) throws IOException {

        // 検索キーワード
        String keyword = "Java";

        // URL作成（エンコード大事！）
        String searchURL = "https://www.google.com/search?q="
                + URLEncoder.encode(keyword, "UTF-8");

        // URLオブジェクト
        URL url = new URL(searchURL);

        // 接続して読み込み
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream())
        );

        // 1行ずつ出力
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}