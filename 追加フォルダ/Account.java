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

    // 🔥 これを追加
    public void withdraw(int amount) {
        balance -= amount;
    }
}