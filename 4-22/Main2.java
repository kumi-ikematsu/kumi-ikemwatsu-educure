import java.io.FileInputStream;
import java.util.Properties;

public class Main2 {
    public static void main(String[] args) {

        String filePath = "exercise.properties";

        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(filePath)) {

            // ファイル読み込み
            properties.load(input);

            // 値取得
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            // 出力
            System.out.println("username=" + username);
            System.out.println("password=" + password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}