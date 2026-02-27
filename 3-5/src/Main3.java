public class Main3 {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount(1000);

        BankAccount account2 = account1;  // 同じインスタンスを参照

        account1.balance += 2000;  // 残高を増やす

        System.out.println("口座1の残高: " + account1.balance);
        System.out.println("口座2の残高: " + account2.balance);
    }
}