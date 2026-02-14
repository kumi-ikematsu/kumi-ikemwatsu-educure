public class Main3 {
    public static void main(String[] args) {

        int height = 5; // ピラミッドの高さ

        for (int row = 1; row <= height; row++) {

            // 左側の空白（段が下がるほど少なく）
            for (int space = 1; space <= height - row; space++) {
                System.out.print(" ");
            }

            // 星（1, 3, 5, 7... と増える）
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }

            System.out.println(); // 改行
        }
    }
}
