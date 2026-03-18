public class Divider {

    public int divide(int a, int b) {

        if (b == 0) {
            throw new IllegalArgumentException("0で割ることはできません");
        }

        return a / b;
    }
}