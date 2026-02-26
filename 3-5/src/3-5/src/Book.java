public class Book {

    int id;
    String title;
    String author;
    int pages;

    // コンストラクタ①（pagesなし）
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = 0;
    }

    // コンストラクタ②（全部あり）
    public Book(int id, String title, String author, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void displayInfo() {
        System.out.println("本" + id + ": " 
                + title + " - " 
                + author + " (" 
                + pages + "ページ)");
    }
}