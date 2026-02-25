public class Main4 {
    public static void main(String[] args) {

        Weapon weapon = new Weapon();
        weapon.setWeapon("伝説の剣", 100);

        for (int i = 0; i < 10; i++) {
            weapon.use();
            System.out.println("攻撃力：" + weapon.getAttack() + " / 耐久度：" + weapon.getDurability());
        }

        weapon.use(); // 使用不可表示

        weapon.repair();

        weapon.use();
        System.out.println("攻撃力：" + weapon.getAttack() + " / 耐久度：" + weapon.getDurability());
    }
}
