public class Main3 {
    public static void main(String[] args) {

        int height = 5; // ピラミッドの高さ

        for (int row = 1; row <= height; row++) {

            // 空白
            for (int s = 0; s < height - row; s++) {
                System.out.print(" ");
            }

            // ★（奇数個）
            for (int star = 0; star < 2 * row - 1; star++) {
                System.out.print("*");
            }

            // 改行
            System.out.println();
        }
    }
}
