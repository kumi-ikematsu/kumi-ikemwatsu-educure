public class Main1 {
    public static void main(String[] args) {
        Pet pet = new Pet("ポチ", 100);

        System.out.println("ポチを生み出しました！");
        System.out.println("初期体力：" + pet.getEnergy());

        pet.eat();
        pet.showEnergy();

        pet.play();
        pet.showEnergy();
    }
}
