public class Main2 {
    public static void main(String[] args) {

        Book book = new Book("Java入門");

        book.lend();       // 1回目 → 貸出成功
        book.lend();       // 2回目 → エラー表示

        book.returnBook(); // 返却

        book.lend();       // 再度貸出
    }
}