public class Account {

    String accountNumber;
    int balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    // 出金メソッドを実装
    public void withdraw(int amount) {
        balance -= amount;
    }
}