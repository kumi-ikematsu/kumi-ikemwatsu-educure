package com.example.vocab;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuizService {

    private VocabularyService service;

    public QuizService(VocabularyService service) {
        this.service = service;
    }

    public void startQuiz() throws Exception {

        List<Vocabulary> list = service.getAll();

        if (list.isEmpty()) {
            System.out.println("データがありません");
            return;
        }

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        Vocabulary v = list.get(rand.nextInt(list.size()));

        System.out.println("意味：" + v.getMeaning());
        System.out.print("単語は？:");

        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase(v.getWord())) {
            System.out.println("正解！");
        } else {
            System.out.println("不正解 正解：" + v.getWord());
        }
    }
}
