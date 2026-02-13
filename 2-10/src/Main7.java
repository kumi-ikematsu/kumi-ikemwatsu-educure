public class Main7 {
    public static void main(String[] args) {

        String key = "key1"; // "key1" または "key2"
        int count = 1;       // 押した回数

        switch (key) {
            case "key1":
                switch (count) {
                    case 1:
                        System.out.println("A");
                        break;
                    case 2:
                        System.out.println("B");
                        break;
                    default:
                        System.out.println("C");
                        break;
                }
                break;

            case "key2":
                switch (count) {
                    case 1:
                        System.out.println("D");
                        break;
                    case 2:
                        System.out.println("E");
                        break;
                    default:
                        System.out.println("F");
                        break;
                }
                break;

            default:
                System.out.println("Invalid key");
        }
    }
}
