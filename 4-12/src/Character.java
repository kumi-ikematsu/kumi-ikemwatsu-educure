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

    // 戦闘力
    public int getBattlePower() {
        return hp + attack;
    }

    // 並び替え（戦闘力の降順）
    @Override
    public int compareTo(Character other) {
        return other.getBattlePower() - this.getBattlePower();
    }

    // 表示用
    @Override
    public String toString() {
        return name + " (HP:" + hp + " 攻撃力:" + attack + ") 戦闘力:" + getBattlePower();
    }
}