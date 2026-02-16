public class Main1 {
    public static void main(String[] args) {
        // ここに配列を作成し、点数を代入するコードを書いてください
        int[] scores = { 85, 90, 75, 95, 80 };

        // ここに点数を表示するコード
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "番目の生徒：" + scores[i] + "点");
        }
    }
}