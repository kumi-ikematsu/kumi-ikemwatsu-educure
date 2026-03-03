public class SavingsAccount implements BankAccount {

    private String name;
    private int balance;

    public SavingsAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "円入金しました");
        } else {
            System.out.println("無効な金額です");
        }
    }

    @Override
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + "円出金しました");
        } else {
            System.out.println("出金できません");
        }
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("口座名義：" + name);
        System.out.println("残高：" + balance);
    }
}