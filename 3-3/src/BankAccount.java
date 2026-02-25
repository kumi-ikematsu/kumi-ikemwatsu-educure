public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + "円預けました");
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "円引き出しました");
        } else {
            System.out.println("残高が不足しています");
        }
    }
}