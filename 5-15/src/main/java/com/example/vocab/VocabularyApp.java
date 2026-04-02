package com.example.vocab;

import java.util.List;
import java.util.Scanner;

public class VocabularyApp {

    private WordManager wordManager;
    private Quiz quiz;
    private FileHandler fileHandler;
    private Scanner scanner;
    private DBManager dbManager;

    public VocabularyApp() {
        this.dbManager = new DBManager();
        this.wordManager = new WordManager(dbManager);
        this.quiz = new Quiz(wordManager);
        this.fileHandler = new FileHandler();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== 英単語暗記アプリ ===");

        while (true) {
            System.out.println("\n1: 単語を登録する");
            System.out.println("2: クイズを受ける");
            System.out.println("3: CSVファイルから単語をインポート");
            System.out.println("4: CSVファイルに単語をエクスポート");
            System.out.println("5: 単語を削除する");
            System.out.println("6: 単語を更新する");
            System.out.println("7: 終了する");
            System.out.print("選択: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1": registerWord(); break;
                case "2": startQuiz(); break;
                case "3": importWords(); break;
                case "4": exportWords(); break;
                case "5": deleteWord(); break;
                case "6": updateWord(); break;
                case "7":
                    cleanup();
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("1〜7の数字を入力してください。");
            }
        }
    }

    private void registerWord() {
        System.out.print("英単語を入力してください: ");
        String english = scanner.nextLine().trim();
        System.out.print("日本語訳を入力してください: ");
        String japanese = scanner.nextLine().trim();

        if (english.isEmpty() || japanese.isEmpty()) {
            System.out.println("入力が空です。登録をキャンセルしました。");
            return;
        }

        Word word = new Word(english, japanese);
        wordManager.addWord(word);
        System.out.println("単語を登録しました。");
    }

    private void startQuiz() {
        if (wordManager.getWordCount() == 0) {
            System.out.println("単語が登録されていません。");
            return;
        }

        quiz.reset();

        System.out.println("=== クイズを開始します ===");
        int count = wordManager.getWordCount();

        for (int i = 0; i < count; i++) {
            Word word = quiz.getRandomWord();
            System.out.println(word.getEnglish() + "の意味は？");
            System.out.print("回答: ");
            String answer = scanner.nextLine().trim();

            if (quiz.checkAnswer(word, answer)) {
                System.out.println("正解です！");
            } else {
                System.out.println("不正解。正解: " + word.getJapanese());
            }
        }

        System.out.println("\nクイズ終了！");
        System.out.println(quiz.getTotalQuestions() + "問中" + quiz.getScore() + "問正解でした！");
    }

    private void importWords() {
        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine().trim();
        fileHandler.importFromCSV(filename, wordManager);
    }

    private void exportWords() {
        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine().trim();
        List<Word> words = wordManager.getWords();
        fileHandler.exportToCSV(words, filename);
    }

    private void deleteWord() {
        System.out.print("削除する英単語を入力してください: ");
        String english = scanner.nextLine().trim();
        wordManager.deleteWord(english);
        System.out.println("単語を削除しました。");
    }

    private void updateWord() {
        System.out.print("更新する英単語を入力してください: ");
        String english = scanner.nextLine().trim();
        System.out.print("新しい日本語訳を入力してください: ");
        String newJapanese = scanner.nextLine().trim();
        wordManager.updateWord(english, newJapanese);
        System.out.println("単語を更新しました。");
    }

    private void cleanup() {
        dbManager.close();
        scanner.close();
    }

    public static void main(String[] args) {
        VocabularyApp app = new VocabularyApp();
        app.start();
    }
}
