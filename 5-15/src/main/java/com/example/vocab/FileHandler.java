package com.example.vocab;

import java.io.*;
import java.util.List;

public class FileHandler {

    public void exportToCSV(List<Word> words, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Word w : words) {
                bw.write(w.getEnglish() + "," + w.getJapanese());
                bw.newLine();
            }
            System.out.println(words.size() + "個の単語を保存しました。");
        } catch (IOException e) {
            System.err.println("エクスポートエラー: " + e.getMessage());
        }
    }

    public void importFromCSV(String filename, WordManager wordManager) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    wordManager.addWord(new Word(data[0].trim(), data[1].trim()));
                    count++;
                }
            }
            System.out.println(count + "個の単語を読み込みました。");
        } catch (IOException e) {
            System.err.println("インポートエラー: " + e.getMessage());
        }
    }
}
