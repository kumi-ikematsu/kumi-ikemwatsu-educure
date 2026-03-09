public class Main4 {

    public static void main(String[] args) {

        System.out.println("=== パーティーメンバー ===");

        PartyMember member1 = new PartyMember("勇者", "アタッカー");
        PartyMember member2 = new PartyMember("僧侶", "ヒーラー");

        System.out.println(member1);
        System.out.println(member2);

        PartyMember copy = member1.clone();

        System.out.println("=== 複製テスト ===");
        System.out.println(copy);
    }
}