public class Divider {

    public double divide(double a, double b) {

        if (b == 0.0) {
            throw new IllegalArgumentException("ゼロでは割れません");
        }

        return a / b;
    }
}