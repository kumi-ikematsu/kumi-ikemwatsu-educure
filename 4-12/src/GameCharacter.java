public class GameCharacter implements Comparable<GameCharacter> {

    private String name;
    private int attack;

    public GameCharacter(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public int compareTo(GameCharacter other) {

        // 安全な比較
        return Integer.compare(this.attack, other.attack);
    }

    @Override
    public String toString() {
        return name + " 攻撃力:" + attack;
    }
}