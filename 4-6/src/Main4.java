import java.util.*;

public class Main4 {
    public static void main(String[] args) {

        // 全モンスター
        ArrayList<String> allMonsters = new ArrayList<>();
        allMonsters.add("スライム");
        allMonsters.add("ドラゴン");
        allMonsters.add("ゴブリン");
        allMonsters.add("フェニックス");
        allMonsters.add("ユニコーン");

        // 発見したモンスター（重複なし）
        HashSet<String> discovered = new HashSet<>();
        discovered.add("スライム");
        discovered.add("ドラゴン");
        discovered.add("ゴブリン");

        // 戦闘履歴（重複あり）
        ArrayList<String> battleHistory = new ArrayList<>();
        battleHistory.add("スライム");
        battleHistory.add("スライム");
        battleHistory.add("スライム");
        battleHistory.add("スライム");
        battleHistory.add("スライム");
        battleHistory.add("ドラゴン");
        battleHistory.add("ドラゴン");
        battleHistory.add("ゴブリン");
        battleHistory.add("ゴブリン");

        // 発見済みモンスター
        System.out.println("発見済みモンスター: " + discovered);

        // 発見済み種類数
        System.out.println("発見済みモンスター数: " + discovered.size());

        // スライムの戦闘回数
        int slimeCount = 0;
        for (String monster : battleHistory) {
            if (monster.equals("スライム")) {
                slimeCount++;
            }
        }
        System.out.println("スライムとの戦闘回数: " + slimeCount);

        // 未発見モンスター
        ArrayList<String> undiscovered = new ArrayList<>();
        for (String monster : allMonsters) {
            if (!discovered.contains(monster)) {
                undiscovered.add(monster);
            }
        }

        System.out.println("未発見のモンスター: " + undiscovered);
    }
}