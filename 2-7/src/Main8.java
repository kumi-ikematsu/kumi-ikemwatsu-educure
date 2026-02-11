package src;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("攻撃力を入力してください：");
        int attack = Integer.parseInt(scanner.nextLine());

        System.out.print("防御力を入力してください：");
        int defense = Integer.parseInt(scanner.nextLine());

        // 通常ダメージ
        int normalDamage = attack - defense;

        // クリティカルダメージ（1.5倍・小数点切り捨て）
        int criticalDamage = (int)(normalDamage * 1.5);

        System.out.println("通常ダメージ：" + normalDamage);
        System.out.println("クリティカルダメージ：" + criticalDamage);

        scanner.close();
    }
}