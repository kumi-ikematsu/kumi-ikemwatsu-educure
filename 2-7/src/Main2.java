package src;

public class Main2 {
    public static void main(String[] args){

        int price = 2500;
        double discountRate = 0.2;

        int discount = (int)(price * discountRate);
        int salePrice = price - discount;

        System.out.println(" 販売額:" + discount + "円");
        System.out.println("販売価格:" + salePrice + "円");
    }
}
