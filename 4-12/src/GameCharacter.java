import java.util.*;

public class GameCharacter {

    private String name;
    private List<Equipment> equipments;

    public GameCharacter(String name) {
        this.name = name;
        this.equipments = new ArrayList<>();
    }

    public void addEquipment(Equipment e) {
        equipments.add(e);
    }

    public void showEquipments() {
        System.out.println("=== キャラクター装備情報 ===");
        System.out.println(name + " の装備:");

        int i = 1;
        for (Equipment e : equipments) {
            System.out.println(i + ". " + e);
            i++;
        }
    }

    public void sortEquipments() {
        Collections.sort(equipments);
    }
}