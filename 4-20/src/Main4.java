import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main4 {
    public static void main(String[] args) {

        try {
            // 元ファイル
            File source = new File("source.txt");

            if (!source.exists()) {
                System.out.println("元ファイルが存在しません。");
                return;
            }

            // backupフォルダ
            File backupDir = new File("backup");
            if (!backupDir.exists()) {
                backupDir.mkdir();
            }

            // archiveフォルダ
            File archiveDir = new File("archive");
            if (!archiveDir.exists()) {
                archiveDir.mkdir();
            }

            // コピー先
            File backupFile = new File(backupDir, "source.txt");

            Files.copy(
                    source.toPath(),
                    backupFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("ファイルが backup/ にコピーされました。");

            // 移動先
            File archiveFile = new File(archiveDir, "source.txt");

            Files.move(
                    backupFile.toPath(),
                    archiveFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("ファイルが archive/ に移動されました。");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}