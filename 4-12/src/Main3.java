import java.util.ArrayList;
import java.util.Collections;

public class Main3 {

    public static void main(String[] args) {

        ArrayList<Character> characters = new ArrayList<>();

        characters.add(new Character("勇者", 100, 50));
        characters.add(new Character("魔法使い", 70, 70));
        characters.add(new Character("戦士", 80, 40));

        Collections.sort(characters);

        System.out.println("=== 戦闘力順 ===");

        for (Character c : characters) {
            System.out.println(c);
        }
    }
}