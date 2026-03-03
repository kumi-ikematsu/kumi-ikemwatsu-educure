public class Main4 {
    public static void main(String[] args) {

        Book book = new Book("Java入門");
        Library library = new Library();

        library.lendBook(book);
        library.lendBook(book);   // エラー確認

        library.returnBook(book);
        library.returnBook(book); // エラー確認
    }
}