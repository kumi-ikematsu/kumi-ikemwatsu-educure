import java.io.IOException;
import java.nio.file.*;

public class Main4 {
    public static void main(String[] args) {

        try {
            Path source = Paths.get("source.txt");

            if (!Files.exists(source)) {
                System.out.println("元ファイルが存在しません。");
                return;
            }

            Path backupDir = Paths.get("backup");
            Files.createDirectories(backupDir);

            Path archiveDir = Paths.get("archive");
            Files.createDirectories(archiveDir);

            // コピー
            Path backupFile = backupDir.resolve("source.txt");
            Files.copy(source, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("ファイルが backup/ にコピーされました。");

            // コピー確認
            if (Files.exists(backupFile)) {
                System.out.println("コピーの確認：成功");
            } else {
                System.out.println("コピーの確認：失敗");
            }

            // 移動
            Path archiveFile = archiveDir.resolve("source.txt");
            Files.move(backupFile, archiveFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("ファイルが archive/ に移動されました。");

            // 移動確認
            if (Files.exists(archiveFile)) {
                System.out.println("移動の確認：成功");
            } else {
                System.out.println("移動の確認：失敗");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
