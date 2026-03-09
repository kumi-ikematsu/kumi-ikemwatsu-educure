import java.util.*;

public class Main3 {
    public static void main(String[] args) {

        Character character1 = new Character("勇者", 500);
        Character character2 = new Character("魔法使い", 300);
        Character character3 = new Character("戦士", 800);

        ArrayList<Character> characters = new ArrayList<>();

        characters.add(character1);
        characters.add(character2);
        characters.add(character3);

        // HPでソート
        Collections.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {

                // 安全な比較
                return Integer.compare(c1.getHp(), c2.getHp());
            }
        });

        for (Character c : characters) {
            System.out.println(c);
        }
    }
}