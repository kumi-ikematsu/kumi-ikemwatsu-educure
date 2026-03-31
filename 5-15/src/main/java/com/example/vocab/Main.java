package com.example.vocab;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        VocabularyService service = new VocabularyService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== メニュー ====");
            System.out.println("1: 登録");
            System.out.println("2: 一覧");
            System.out.println("3: 更新");
            System.out.println("4: 削除");
            System.out.println("0: 終了");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("単語: ");
                    String word = scanner.nextLine();

                    System.out.print("意味: ");
                    String meaning = scanner.nextLine();

                    service.add(word, meaning);
                    break;

                case 2:
                    List<Vocabulary> list = service.getAll();
                    for (Vocabulary v : list) {
                        System.out.println(v);
                    }
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("新しい意味: ");
                    String newMeaning = scanner.nextLine();

                    service.update(id, newMeaning);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int deleteId = scanner.nextInt();

                    service.delete(deleteId);
                    break;

                case 0:
                    System.out.println("終了します");
                    return;
            }
        }
    }
}
