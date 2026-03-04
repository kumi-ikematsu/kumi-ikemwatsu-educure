public class Main4 {

    public static void main(String[] args) {

        // 初期レートでドル換算
        int yen = ExchangeRate.convertToJPY("USD", 100);
        System.out.println("100ドル = " + yen + "円");

        // レート更新
        ExchangeRate.updateRates(150.0, 160.0);

        // 更新後ドル換算
        yen = ExchangeRate.convertToJPY("USD", 100);
        System.out.println("100ドル = " + yen + "円");

        // ユーロ換算
        yen = ExchangeRate.convertToJPY("EUR", 80);
        System.out.println("80ユーロ = " + yen + "円");
    }
}