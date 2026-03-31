package com.example.vocab;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Connection con = DBUtil.getConnection();

            VocabularyService service = new VocabularyService(con);
            QuizService quizService = new QuizService(service);
            CSVService csvService = new CSVService(service);

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("==== メニュー ====");
                System.out.println("1:登録");
                System.out.println("2:一覧");
                System.out.println("3:更新");
                System.out.println("4:削除");
                System.out.println("5:クイズ");
                System.out.println("6:インポート");
                System.out.println("7:エクスポート");
                System.out.println("0:終了");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("単語:");
                        String word = sc.nextLine();
                        System.out.print("意味:");
                        String meaning = sc.nextLine();

                        if (service.add(word, meaning)) {
                            System.out.println("登録完了");
                        }
                        break;

                    case 2:
                        List<Vocabulary> list = service.getAll();
                        for (Vocabulary v : list) {
                            System.out.println(v.getWord() + " : " + v.getMeaning());
                        }
                        break;

                    case 3:
                        System.out.print("単語:");
                        String w = sc.nextLine();
                        System.out.print("新しい意味:");
                        String m = sc.nextLine();

                        if (service.update(w, m)) {
                            System.out.println("更新完了");
                        } else {
                            System.out.println("該当なし");
                        }
                        break;

                    case 4:
                        System.out.print("単語:");
                        String d = sc.nextLine();

                        if (service.delete(d)) {
                            System.out.println("削除完了");
                        } else {
                            System.out.println("該当なし");
                        }
                        break;

                    case 5:
                        quizService.startQuiz();
                        break;

                    case 6:
                        csvService.importCSV("input.csv");
                        System.out.println("インポート完了");
                        break;

                    case 7:
                        csvService.exportCSV("output.csv");
                        System.out.println("エクスポート完了");
                        break;

                    case 0:
                        System.out.println("終了");
                        return;
                }
            }

        } catch (Exception e) {
            System.out.println("エラーが発生しました：" + e.getMessage());
        }
    }
}
