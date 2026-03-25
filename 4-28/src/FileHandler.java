import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {

    public void exportToCSV(List<Word> words, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (Word word : words) {
            writer.write(word.getEnglish() + "," + word.getJapanese());
            writer.newLine();
        }

        writer.close();
    }

    public int importFromCSV(String filename, WordManager wordManager) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");

            if (parts.length != 2) {
                reader.close();
                throw new IOException("CSVファイルの形式が不正です。");
            }

            String english = parts[0].trim();
            String japanese = parts[1].trim();

            if (english.isEmpty() || japanese.isEmpty()) {
                reader.close();
                throw new IOException("CSVファイルの形式が不正です。");
            }

            wordManager.addWord(new Word(english, japanese));
            count++;
        }

        reader.close();
        return count;
    }
}