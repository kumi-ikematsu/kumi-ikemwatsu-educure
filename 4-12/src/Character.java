public class Character implements Comparable<Character> {

    private String name;
    private int hp;
    private int attack;

    // コンストラクタ
    public Character(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    // 戦闘力
    public int getPower() {
        return hp + attack;
    }

    // 降順ソート（戦闘力）
    @Override
    public int compareTo(Character other) {
        return Integer.compare(other.getPower(), this.getPower());
    }

    // 出力
    @Override
    public String toString() {
        return name + " HP:" + hp + " 攻撃力:" + attack + " 戦闘力:" + getPower();
    }
}