import java.util.*;

public class Main3 {

    public static void main(String[] args) {

        Character character1 = new Character("勇者", 500, 80);
        Character character2 = new Character("魔法使い", 300, 120);
        Character character3 = new Character("戦士", 800, 60);

        ArrayList<Character> characters = new ArrayList<>();

        characters.add(character1);
        characters.add(character2);
        characters.add(character3);

        Collections.sort(characters);

        // ヘッダー
        System.out.println("名前 HP 攻撃力 戦闘力");

        for (Character c : characters) {
            System.out.println(c);
        }
    }
}