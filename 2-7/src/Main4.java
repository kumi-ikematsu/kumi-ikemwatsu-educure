package src;

public class Main4 {
    public static void main(String[] args){

        int pricePer100g = 138;
        double weight = 315.8;

        double total = pricePer100g * (weight / 100);

        int result = (int) total;

        System.out.println("合計金額:" + result + "円です");
    }
}
