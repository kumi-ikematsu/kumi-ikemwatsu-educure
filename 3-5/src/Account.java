public class Account {

    private String accountNumber;
    private int balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    // 入金
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("入金額は0より大きい値を指定してください。");
        }
    }

    // 出金
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount <= 0) {
            System.out.println("出金額は0より大きい値を指定してください。");
        } else {
            System.out.println("残高が不足しています。");
        }
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}