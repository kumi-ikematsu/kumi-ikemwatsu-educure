public class Wizard extends GameCharacter {

    private int mp;

    public Wizard(String name, int hp, int mp) {
        super(name, hp);   // 🔥 親コンストラクタを最初に呼ぶ
        this.mp = mp;
    }

    @Override
    public void showStatus() {
        super.showStatus();   // 🔥 親の表示を呼び出す
        System.out.println("MP: " + mp);
    }
}