public class Student {

    private String name;
    private int score;

    // 名前のsetter
    public void setName(String name) {
        if (name != null && name.length() >= 1 && name.length() <= 20) {
            this.name = name;
        } else {
            System.out.println("エラー：名前は1-20文字で設定してください");
        }
    }

    // 名前のgetter
    public String getName() {
        return name;
    }

    // 点数のsetter
    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("エラー：点数は0-100の範囲で設定してください");
        }
    }

    // 点数のgetter
    public int getScore() {
        return score;
    }
}