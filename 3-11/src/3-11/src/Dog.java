public class Dog implements Animal {

    private String name;
    private int age;

    // コンストラクタ
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 鳴く
    @Override
    public void makeSound() {
        System.out.println("ワンワン");
    }

    // 食べる
    @Override
    public void eat() {
        System.out.println(name + "が餌を食べています");
    }
}