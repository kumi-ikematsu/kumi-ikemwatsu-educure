public class GameCharacter {

    protected String name;
    protected int hp;

    public GameCharacter(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void showStatus() {
        System.out.println("名前: " + name);
        System.out.println("HP: " + hp);
    }
}