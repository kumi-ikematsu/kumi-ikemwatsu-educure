public class Account {

    String accountNumber;
    int balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;   // 初期残高は0
    }

    public void deposit(int amount) {
        balance += amount;
    }
}