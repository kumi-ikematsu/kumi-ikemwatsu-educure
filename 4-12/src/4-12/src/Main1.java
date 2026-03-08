public class Main1 {

    public static void main(String[] args) {

        GameItem potion = new GameItem("回復薬", 100);
        GameItem wand = new GameItem("魔法の杖", 1500);

        System.out.println("アイテム情報:");
        System.out.println(potion);
        System.out.println(wand);
    }
}