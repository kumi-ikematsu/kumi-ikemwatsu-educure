import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] seats = new int[5][6];

        // 事前に予約済みにする席（例）
        seats[0][1] = 1;
        seats[1][3] = 1;
        seats[3][0] = 1;
        seats[4][2] = 1;

        // 現在の座席状況表示
        System.out.println("現在の座席状況：");
        printSeats(seats);

        System.out.print("予約したい座席の行番号（1-5）：");
        int row = scanner.nextInt();

        System.out.print("予約したい座席の列番号（1-6）：");
        int col = scanner.nextInt();

        // 範囲チェック
        if (row < 1 || row > 5 || col < 1 || col > 6) {
            System.out.println("無効な座席番号です。");
        } else if (seats[row - 1][col - 1] == 1) {
            System.out.println("指定された座席はすでに予約済みです。");
        } else {
            seats[row - 1][col - 1] = 1;
            System.out.println(row + "行" + col + "列の座席を予約しました。");
        }

        // 予約後表示
        System.out.println("予約後の座席状況：");
        printSeats(seats);

        scanner.close();
    }

    // 座席表示用メソッド
    public static void printSeats(int[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}
