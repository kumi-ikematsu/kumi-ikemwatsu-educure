public class Main1 {
    public static void main(String[] args) {

        // 初期残高1000円
        BankAccount account = new BankAccount(1000);

        System.out.println("残高: " + account.getBalance() + "円");

        // 2000円入金
        account.deposit(2000);
        System.out.println("残高: " + account.getBalance() + "円");

        // 1500円出金
        account.withdraw(1500);
        System.out.println("残高: " + account.getBalance() + "円");

        // 残高不足の出金
        account.withdraw(5000);
    }
}