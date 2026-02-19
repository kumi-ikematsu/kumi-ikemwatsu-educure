import java.util.Scanner;

public class Main {

    // 最大登録数
    private static final int MAX_WORDS = 20;

    private static String[] englishWords = new String[MAX_WORDS];
    private static String[] japaneseMeanings = new String[MAX_WORDS];
    private static int wordCount = 0; // 登録済み単語数

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();

            String choice = scanner.nextLine().trim();

            if (!isValidMenuChoice(choice)) {
                System.out.println("1-3の数字を入力してください");
                System.out.println();
                continue;
            }

            int menu = Integer.parseInt(choice);

            if (menu == 1) {
                registerWord(scanner);
            } else if (menu == 2) {
                startQuiz(scanner);
            } else { // 3
                System.out.println("終了します");
                break;
            }

            System.out.println();
        }

        scanner.close();
    }

    // メニュー表示
    private static void showMenu() {
        System.out.println("1: 単語を登録する");
        System.out.println("2: クイズを受ける");
        System.out.println("3: 終了する");
        System.out.println();
    }

    // メニュー入力チェック（1〜3のみ）
    private static boolean isValidMenuChoice(String input) {
        return input.equals("1") || input.equals("2") || input.equals("3");
    }

    // 単語登録
    private static void registerWord(Scanner scanner) {
        if (wordCount >= MAX_WORDS) {
            System.out.println("登録可能な単語数は20個までです");
            return;
        }

        System.out.println("英単語を入力してください：");
        String eng = scanner.nextLine().trim();

        System.out.println("日本語訳を入力してください：");
        String jpn = scanner.nextLine().trim();

        englishWords[wordCount] = eng;
        japaneseMeanings[wordCount] = jpn;
        wordCount++;

        // 仕様に明確な成功メッセージはないので、余計な表示はしない
    }

    // クイズ開始
    private static void startQuiz(Scanner scanner) {
        if (wordCount == 0) {
            System.out.println("単語が登録されていません");
            return;
        }

        int correctCount = 0;

        for (int i = 0; i < wordCount; i++) {
            String eng = englishWords[i];
            String correctJpn = japaneseMeanings[i];

            System.out.println(eng + "の意味は？");
            String answer = scanner.nextLine().trim();

            if (answer.equals(correctJpn)) {
                System.out.println("正解です！");
                correctCount++;
            } else {
                System.out.println("不正解です");
            }

            System.out.println();
        }

        System.out.println("クイズ終了！");
        System.out.println(wordCount + "問中" + correctCount + "問正解でした！");
    }
}
