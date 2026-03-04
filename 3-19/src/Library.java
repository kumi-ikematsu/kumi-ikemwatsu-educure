public class Library {

    // 貸出可能な本の総数
    static int availableBooks = 100;

    // 本を借りる
    public static void borrowBook() {

        if (availableBooks <= 0) {
            System.out.println("エラー：貸出可能な本がありません");
        } else {
            availableBooks--;
            System.out.println("1冊借りました");
        }
    }

    // 本を返却
    public static void returnBook() {
        availableBooks++;
        System.out.println("本を返却しました");
    }

    // 残り冊数取得
    public static int getAvailableBooks() {
        return availableBooks;
    }
}