import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

import java.io.File;

public class Main3 {
    public static void main(String[] args) {

        try {
            File file = new File("exercise.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();

            // 各要素取得
            String title = document.getElementsByTagName("title").item(0).getTextContent();
            String author = document.getElementsByTagName("author").item(0).getTextContent();
            int price = Integer.parseInt(
                    document.getElementsByTagName("price").item(0).getTextContent()
            );

            // Bookにセット
            Book book = new Book(title, author, price);

            // 出力
            System.out.println("タイトル: " + book.getTitle());
            System.out.println("著者: " + book.getAuthor());
            System.out.println("価格: " + book.getPrice());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}