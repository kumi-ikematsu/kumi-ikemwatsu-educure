public class Main2 {

    public static void main(String[] args) {

        Player player = new Player("勇者", 30);
        HealingPotion potion = new HealingPotion();

        player.displayInfo();

        potion.heal(player);  // 回復処理

        // 🔥 表示はここで行う
        System.out.println("回復ポーションを使用しました");
        System.out.println("プレイヤーのHP: " + player.hp);
    }
}