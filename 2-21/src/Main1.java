public class Main1 {

    public static void main(String[] args) {
        processString("Hello World");
    }

    public static void processString(String input) {

        // 大文字に変換
        String upper = input.toUpperCase();

        // 文字数を取得
        int length = input.length();

        System.out.println("大文字：" + upper);
        System.out.println("文字数：" + length);
    }
}
