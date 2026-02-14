public class Main2 {
    public static void main(String[] args) {

        for (int dan = 1; dan <= 5; dan++) {

            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + " x " + i + " = " + (dan * i));
            }

            System.out.println(); // 段ごとに空行
        }
    }
}
