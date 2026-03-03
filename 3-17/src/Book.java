public class Book {

    private String title;
    private boolean isLent;

    // コンストラクタ
    public Book(String title) {
        this.title = title;
        this.isLent = false; // 初期は未貸出
    }

    public String getTitle() {
        return title;
    }

    public boolean isLent() {
        return isLent;
    }

    // 貸出状態変更（protected）
    protected void setLent(boolean status) {
        this.isLent = status;
    }
}