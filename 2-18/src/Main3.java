public class Main3 {

    public static void main(String[] args) {

        String input = "Hello";

        String result = reverseString(input);

        System.out.println("入力：" + input);
        System.out.println("出力：" + result);
    }

    // 文字列を逆順にするメソッド
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
