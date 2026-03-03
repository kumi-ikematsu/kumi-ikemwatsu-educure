public class BankAccount {

    private int balance; // 残高（カプセル化）

    // コンストラクタ
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // 残高取得
    public int getBalance() {
        return balance;
    }

    // 入金
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "円入金しました");
        } else {
            System.out.println("無効な金額です");
        }
    }

    // 出金
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("引き出し失敗しました。残高が不足しています。");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println(amount + "円引き出しました");
        } else {
            System.out.println("無効な金額です");
        }
    }
}