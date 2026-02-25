public class Pet {
    private String name;
    private int energy;

    public Pet(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public void eat() {
        energy += 10;
        System.out.println(name + "は食事をして元気になった！");
    }

    public void play() {
        energy -= 20;
        System.out.println(name + "は遊んで疲れた！");
    }

    public void showEnergy() {
        System.out.println("現在の体力：" + energy);
    }

    public int getEnergy() {
        return energy;
    }
}
