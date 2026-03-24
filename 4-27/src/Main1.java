import java.io.*;
import java.net.*;

public class Main1 {
    public static void main(String[] args) throws IOException {

        // 検索キーワード
        String keyword = "Java";

        // URL作成（エンコード）
        String searchURL = "https://www.google.com/search?q="
                + URLEncoder.encode(keyword, "UTF-8");

        // URLオブジェクト
        URL url = new URL(searchURL);

        // ストリーム取得
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is);

        // 1文字ずつ読み込む
        int data;
        while ((data = isr.read()) != -1) {
            System.out.print((char) data);
        }

        isr.close();
    }
}