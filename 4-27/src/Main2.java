import java.io.*;
import java.net.*;

public class Main2 {
    public static void main(String[] args) {

        try {
            // 検索キーワード
            String keyword = "Java";

            // URL作成（エンコード）
            String searchURL = "https://www.google.com/search?q="
                    + URLEncoder.encode(keyword, "UTF-8");

            URL url = new URL(searchURL);

            // ★ここがポイント（URLConnection）
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}