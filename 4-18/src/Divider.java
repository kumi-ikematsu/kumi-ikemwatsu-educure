public class Divider {

    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new IllegalArgumentException("ゼロでは除算できません");
        }
        return a / b;
    }
}