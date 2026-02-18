import java.util.Date;

public class Main3 {

    public static void main(String[] args) {
        showCurrentTime();
    }

    public static void showCurrentTime() {

        Date now = new Date();   // 現在日時を取得

        System.out.println("現在の日時：" + now);
    }
}
