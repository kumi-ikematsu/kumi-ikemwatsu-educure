import java.io.IOException;
import java.util.Scanner;

public class VocabularyApp {
    private WordManager wordManager;
    private Quiz quiz;
    private FileHandler fileHandler;
    private Scanner scanner;

    public VocabularyApp() {
        wordManager = new WordManager();
        quiz = new Quiz(wordManager);
        fileHandler = new FileHandler();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("=== 英単語暗記アプリ ===");
            System.out.println("1: 単語を登録する");
            System.out.println("2: クイズを受ける");
            System.out.println("3: CSVファイルから単語をインポート");
            System.out.println("4: CSVファイルに単語をエクスポート");
            System.out.println("5: 終了する");
            System.out.print("メニューを選択してください: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    registerWord();
                    break;
                case "2":
                    startQuiz();
                    break;
                case "3":
                    importWords();
                    break;
                case "4":
                    exportWords();
                    break;
                case "5":
                    System.out.println("アプリを終了します。");
                    running = false;
                    break;
                default:
                    System.out.println("1〜5の数字を入力してください。");
            }

            System.out.println();
        }

        scanner.close();
    }

    private void registerWord() {
        System.out.println("【単語登録時】");
        System.out.print("英単語を入力してください: ");
        String english = scanner.nextLine().trim();

        System.out.print("日本語訳を入力してください: ");
        String japanese = scanner.nextLine().trim();

        if (english.isEmpty() || japanese.isEmpty()) {
            System.out.println("エラー: 英単語と日本語訳の両方を入力してください。");
            return;
        }

        Word word = new Word(english, japanese);
        wordManager.addWord(word);
        System.out.println("単語を登録しました。");
    }

    private void startQuiz() {
        System.out.println("【クイズ実施時】");

        if (wordManager.getWordCount() == 0) {
            System.out.println("登録された単語がありません。");
            return;
        }

        Quiz currentQuiz = new Quiz(wordManager);

        System.out.println("=== クイズを開始します ===");

        int questionCount = wordManager.getWordCount();

        for (int i = 0; i < questionCount; i++) {
            Word word = currentQuiz.getRandomWord();

            System.out.println(word.getEnglish() + "の意味は？");
            String answer = scanner.nextLine().trim();

            boolean result = currentQuiz.checkAnswer(word, answer);

            if (result) {
                System.out.println("正解です！");
            } else {
                System.out.println("不正解です。正解は" + word.getJapanese() + "でした。");
            }
        }

        System.out.println();
        System.out.println("クイズ終了！");
        System.out.println(currentQuiz.getTotalQuestions() + "問中"
                + currentQuiz.getScore() + "問正解でした！");
    }

    private void importWords() {
        System.out.println("【CSVファイルからインポート時】");
        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine().trim();

        try {
            int count = fileHandler.importFromCSV(filename, wordManager);
            System.out.println(count + "個の単語を読み込みました。");
        } catch (IOException e) {
            System.out.println("エラー: " + e.getMessage());
        }
    }

    private void exportWords() {
        System.out.println("【CSVファイルへエクスポート時】");
        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine().trim();

        try {
            fileHandler.exportToCSV(wordManager.getWords(), filename);
            System.out.println(wordManager.getWordCount() + "個の単語を保存しました。");
        } catch (IOException e) {
            System.out.println("エラー: ファイルの保存に失敗しました。");
        }
    }

    public static void main(String[] args) {
        VocabularyApp app = new VocabularyApp();
        app.start();
    }
}