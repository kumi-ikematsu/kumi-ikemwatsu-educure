public class Main5 {

    public static void main(String[] args) {

        GameCharacter hero = new GameCharacter("勇者A");

        Equipment sword = new Equipment("伝説の剣", 100, 0);
        Equipment shield = new Equipment("光の盾", 0, 80);
        Equipment boots = new Equipment("魔法の靴", 10, 20);

        hero.addEquipment(sword);
        hero.addEquipment(shield);
        hero.addEquipment(boots);

        hero.showEquipments();

        Equipment copy = sword.clone();

        if (sword.equals(copy)) {
            System.out.println("装備の複製テスト：OK");
        } else {
            System.out.println("装備の複製テスト：NG");
        }

        if (sword.compareTo(shield) < 0) {
            System.out.println("装備の比較テスト：OK");
        } else {
            System.out.println("装備の比較テスト：NG");
        }

        hero.sortEquipments();
        System.out.println("装備の強さソート：OK");
    }
}