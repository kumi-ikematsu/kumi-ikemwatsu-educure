import java.io.*;
import java.net.*;

public class Main2 {
public static void main(String[] args) {

```
    try {
        // 検索キーワード（文字列として設定）
        String keyword = "Java";

        // エンドポイント：国立国会図書館サーチ SRU API
        // query=title="Java"：タイトルに"Java"を含む資料を検索（CQL形式）
        String query = "title=\"" + keyword + "\"";
        String searchURL = "https://ndlsearch.ndl.go.jp/api/sru"
                + "?operation=searchRetrieve"
                + "&query=" + URLEncoder.encode(query, "UTF-8");

        URL url = new URL(searchURL);

        // URLクラスを使用してAPIにアクセス
        URLConnection connection = url.openConnection();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "UTF-8")
        );

        // 検索結果のXMLをコンソールに表示
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

}
