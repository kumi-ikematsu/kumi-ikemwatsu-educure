public class Weapon {

    private String name;
    private int attack;
    private int durability;
    private final int MAX_DURABILITY = 10;
    private boolean isRepaired;

    public Weapon(String name, int attack) {
        this.name = name;
        this.attack = attack;
        this.durability = MAX_DURABILITY;
        this.isRepaired = false;
        System.out.println(name + "を作成しました（攻撃力：" + attack + "）");
    }
    
public void use() {
    if (durability > 0) {
        durability--;
        System.out.println("武器を使用しました！残り耐久度：" + durability);
    } else {
        System.out.println("武器は完全に劣化しています。修理が必要です！");
    }
}

    public void repair() {
        durability = MAX_DURABILITY;
        isRepaired = true;
        System.out.println("武器を修理しました");
    }

    public int getAttack() {
        return attack;
    }

    public int getDurability() {
        return durability;
    }
}