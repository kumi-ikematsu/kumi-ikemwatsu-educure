public class Main5 {

    public static void main(String[] args) {

        Book book1 = new Book(1, "Java入門", "山田太郎");

        Book book2 = new Book(2, "Python実践", "鈴木次郎", 300);

        book1.displayInfo();
        book2.displayInfo();
    }
}