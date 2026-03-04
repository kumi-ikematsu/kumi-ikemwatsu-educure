public class ExchangeRate {

    static double usdRate = 145.0;
    static double eurRate = 160.0;

    // レート更新
    public static void updateRates(double newUsdRate, double newEurRate) {
        usdRate = newUsdRate;
        eurRate = newEurRate;
        System.out.println("レート更新");
    }

    // 日本円換算
    public static int convertToJPY(String currency, double amount) {

        double result = 0;

        if (currency.equals("USD")) {
            result = amount * usdRate;
        } else if (currency.equals("EUR")) {
            result = amount * eurRate;
        } else {
            return -1;
        }

        return (int) result; // 小数点切り捨て
    }
}