package com.example.vocab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public int exportToCSV(List<Word> words, String filename) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Word w : words) {
                bw.write(w.getEnglish() + "," + w.getJapanese());
                bw.newLine();
            }
        }
        return words.size();
    }

    public List<Word> importFromCSV(String filename) throws IOException {
        List<Word> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    list.add(new Word(data[0].trim(), data[1].trim()));
                }
            }
        }
        return list;
    }
}
