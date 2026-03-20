import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main4 {
    public static void main(String[] args) {

        try {
            Path source = Paths.get("source.txt");

            if (!Files.exists(source)) {
                System.out.println("元ファイルが存在しません。");
                return;
            }

            // フォルダ作成（親もまとめて）
            Path backupDir = Paths.get("backup");
            Files.createDirectories(backupDir);

            Path archiveDir = Paths.get("archive");
            Files.createDirectories(archiveDir);

            // コピー
            Path backupFile = backupDir.resolve("source.txt");
            Files.copy(source, backupFile, StandardCopyOption.REPLACE_EXISTING);

            if (Files.exists(backupFile)) {
                System.out.println("コピー成功：backup に存在します。");
            } else {
                System.out.println("コピー失敗");
            }

            // 移動
            Path archiveFile = archiveDir.resolve("source.txt");
            Files.move(backupFile, archiveFile, StandardCopyOption.REPLACE_EXISTING);

            if (Files.exists(archiveFile)) {
                System.out.println("移動成功：archive に存在します。");
            } else {
                System.out.println("移動失敗");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
