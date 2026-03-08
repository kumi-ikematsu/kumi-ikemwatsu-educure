import java.util.*;

public class Main3 {

    public static void main(String[] args) {

        List<Character> characters = new ArrayList<>();

        characters.add(new Character("勇者", 120));
        characters.add(new Character("魔法使い", 80));
        characters.add(new Character("戦士", 150));

        System.out.println("=== キャラクター一覧 ===");

        for (Character c : characters) {
            System.out.println(c);
        }

        Collections.sort(characters);

        System.out.println("=== HP順にソート ===");

        for (Character c : characters) {
            System.out.println(c);
        }
    }
}