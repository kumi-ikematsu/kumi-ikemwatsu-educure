public class Book {

    private String title;
    private boolean isLent; // 貸出中かどうか

    // コンストラクタ
    public Book(String title) {
        this.title = title;
        this.isLent = false;
        System.out.println("「" + title + "」を登録しました");
    }

    // タイトル取得
    public String getTitle() {
        return title;
    }

    // タイトル変更
    public void setTitle(String title) {
        this.title = title;
    }

    // 貸し出し
    public void lend() {
        if (isLent) {
            System.out.println("申し訳ありません。この本は貸出中です");
        } else {
            isLent = true;
            System.out.println("本を貸し出しました");
        }
    }

    // 返却
    public void returnBook() {
        if (isLent) {
            isLent = false;
            System.out.println("本が返却されました");
        } else {
            System.out.println("この本は貸出中ではありません");
        }
    }
}