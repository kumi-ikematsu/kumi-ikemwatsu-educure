public class Main3 {

    public static boolean isValidUsername(String username) {
        return username.matches("^(?=.*[A-Za-z])[A-Za-z0-9_]{4,16}$");
    }

    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[0-9]).{8,}$");
    }

    public static void main(String[] args) {

        String[] usernames = {"Player_1", "123456", "P@layer"};
        String[] passwords = {"Password123", "password123", "Pass"};

        System.out.println("ユーザー名チェック:");
        for (String u : usernames) {
            System.out.println(u + ": " + (isValidUsername(u) ? "有効" : "無効"));
        }

        System.out.println("パスワードチェック:");
        for (String p : passwords) {
            System.out.println(p + ": " + (isValidPassword(p) ? "有効" : "無効"));
        }
    }
}