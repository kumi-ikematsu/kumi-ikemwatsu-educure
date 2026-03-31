package com.example.vocab;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Connection con = DBUtil.getConnection();
            VocabularyService service = new VocabularyService(con);
            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("1:登録 2:一覧 3:更新 4:削除 0:終了");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("単語:");
                        String word = scanner.nextLine();

                        System.out.print("意味:");
                        String meaning = scanner.nextLine();

                        if (service.add(word, meaning)) {
                            System.out.println("登録成功");
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
                        String w1 = scanner.nextLine();

                        System.out.print("新しい意味:");
                        String m1 = scanner.nextLine();

                        if (service.update(w1, m1)) {
                            System.out.println("更新成功");
                        } else {
                            System.out.println("該当なし");
                        }
                        break;

                    case 4:
                        System.out.print("単語:");
                        String w2 = scanner.nextLine();

                        if (service.delete(w2)) {
                            System.out.println("削除成功");
                        } else {
                            System.out.println("該当なし");
                        }
                        break;

                    case 0:
                        System.out.println("終了");
                        return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
