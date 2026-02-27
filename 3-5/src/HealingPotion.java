public class HealingPotion {

    public void heal(Player player) {
        player.hp += 50;
        System.out.println("回復ポーションを使用しました");
    }
}