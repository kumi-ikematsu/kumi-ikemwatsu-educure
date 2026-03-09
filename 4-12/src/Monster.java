import java.util.Objects;

public class Monster {

    private String name;
    private int level;

    // コンストラクタ
    public Monster(String name, int level) {
        this.name = name;
        this.level = level;
    }

    // equalsメソッドをオーバーライド
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Monster other = (Monster) obj;

        return Objects.equals(name, other.name) && level == other.level;
    }

    // hashCodeメソッドをオーバーライド
    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    // 表示用
    @Override
    public String toString() {
        return name + "Lv." + level;
    }
}