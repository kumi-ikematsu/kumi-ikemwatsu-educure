import java.util.*;

public class Main5 {
    public static void main(String[] args) {

        ArrayList<GameCharacter> characters = new ArrayList<>();

        characters.add(new GameCharacter("勇者", 80));
        characters.add(new GameCharacter("戦士", 100));
        characters.add(new GameCharacter("魔法使い", 60));

        // ソート
        Collections.sort(characters);

        // ソート結果を確認
        for (GameCharacter c : characters) {
            System.out.println(c);
        }
    }
}