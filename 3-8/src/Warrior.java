public class Warrior extends Character {

    public String job = "戦士";

    public Warrior(String name, int hp) {
        super(name, hp);   // 🔥 親コンストラクタ呼び出し
    }

    @Override
    public void showStatus() {
        super.showStatus();   // 🔥 親のメソッド呼び出し
        System.out.println("職業: " + job);
    }
}