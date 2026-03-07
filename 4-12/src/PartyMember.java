import java.util.ArrayList;

public class PartyMember implements Cloneable {

    private String name;
    private ArrayList<String> skills;

    // コンストラクタ
    public PartyMember(String name) {
        this.name = name;
        this.skills = new ArrayList<>();
    }

    // スキル追加
    public void addSkill(String skill) {
        skills.add(skill);
    }

    // 深いコピー
    @Override
    public PartyMember clone() {

        try {
            PartyMember copy = (PartyMember) super.clone();
            copy.skills = new ArrayList<>(this.skills);
            return copy;

        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // 表示
    public void showSkills() {
        System.out.println("キャラクター「" + name + "」のスキル: " + skills);
    }
}