public class Main8 {
    public static void main(String[] args) {

        int score = 85; // ここに点数を入力

        switch (score / 10) {
            case 10: // 100
            case 9:  // 90-99
                System.out.println("A");
                break;

            case 8:  // 80-89
                System.out.println("B");
                break;

            case 7:  // 70-79
                System.out.println("C");
                break;

            case 6:  // 60-69
                System.out.println("D");
                break;

            default:
                System.out.println("F");
        }
    }
}
