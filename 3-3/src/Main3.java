public class Main3 {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(0);

        System.out.println("残高: " + account.getBalance() + "円");

        account.deposit(10000);
        System.out.println("残高: " + account.getBalance() + "円");

        account.withdraw(3000);
        System.out.println("残高: " + account.getBalance() + "円");

        account.withdraw(8000);
    }
}