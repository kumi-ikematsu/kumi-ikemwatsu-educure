public class Equipment implements Cloneable, Comparable<Equipment> {

    private String name;
    private int attack;
    private int defense;

    public Equipment(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public int getPower() {
        return attack + defense;
    }

    @Override
    public Equipment clone() {
        try {
            return (Equipment) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Equipment)) return false;

        Equipment other = (Equipment) obj;

        return name.equals(other.name)
                && attack == other.attack
                && defense == other.defense;
    }

    // 総合力で比較（降順）
    @Override
    public int compareTo(Equipment other) {
        return Integer.compare(other.getPower(), this.getPower());
    }

    @Override
    public String toString() {
        return name + " (攻撃力:" + attack + " 防御力:" + defense + ")";
    }
}