public class PartyMember implements Cloneable {

    private String name;
    private String role;

    // コンストラクタ
    public PartyMember(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    // cloneメソッド
    @Override
    public PartyMember clone() {
        try {
            return (PartyMember) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("複製に失敗しました");
        }
    }

    // 表示
    @Override
    public String toString() {
        return name + " (" + role + ")";
    }
}