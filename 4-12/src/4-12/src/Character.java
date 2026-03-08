public class Character implements Comparable<Character> {

    private String name;
    private int hp;

    // コンストラクタ
    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    // compareTo（安全な比較）
    @Override
    public int compareTo(Character other) {
        return Integer.compare(this.hp, other.hp);
    }

    // 表示
    @Override
    public String toString() {
        return name + " (HP:" + hp + ")";
    }
}