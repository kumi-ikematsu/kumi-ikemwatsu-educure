public class Main4 {

    public static void main(String[] args) {

        System.out.println("=== 深いコピー後にスキル追加 ===");

        // オリジナル
        PartyMember original = new PartyMember("アリス");
        original.addSkill("ファイア");
        original.addSkill("ブリザード");

        // コピー
        PartyMember copy = original.clone();

        // コピー側だけスキル追加
        copy.addSkill("サンダー");

        // 表示
        System.out.print("元のキャラクター ");
        original.showSkills();

        System.out.print("コピーしたキャラクター ");
        copy.showSkills();
    }
}