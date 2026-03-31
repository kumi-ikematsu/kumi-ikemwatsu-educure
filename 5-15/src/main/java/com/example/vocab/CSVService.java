package com.example.vocab;

import java.io.*;
import java.util.List;

public class CSVService {

    private VocabularyService service;

    public CSVService(VocabularyService service) {
        this.service = service;
    }

    public void importCSV(String file) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");
            service.add(data[0], data[1]);
        }

        br.close();
    }

    public void exportCSV(String file) throws Exception {

        List<Vocabulary> list = service.getAll();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (Vocabulary v : list) {
            bw.write(v.getWord() + "," + v.getMeaning());
            bw.newLine();
        }

        bw.close();
    }
}
