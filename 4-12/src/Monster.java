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

        return name.equals(other.name) && level == other.level;
    }

    // 表示用
    @Override
    public String toString() {
        return name + "Lv." + level;
    }
}