import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main2 {
    public static void main(String[] args) {

        try {
            // 検索キーワード
            String keyword = "Java";

            // ▼ クエリ（CQL）
            String query = "title=\"" + keyword + "\"";

            // ▼ パラメータ付きURL（必要パラメータも追加）
            String searchURL = "https://ndlsearch.ndl.go.jp/api/sru"
                    + "?operation=searchRetrieve"
                    + "&query=" + URLEncoder.encode(query, StandardCharsets.UTF_8)
                    + "&maximumRecords=10"; // ← 例：取得件数指定

            URL url = new URL(searchURL);

            // ▼ HttpURLConnectionを使用（←ここ重要）
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            int status = conn.getResponseCode();

            BufferedReader reader;

            if (status == 200) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            } else {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8));
            }

            // ▼ レスポンス出力
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
